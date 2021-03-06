package io.dcloud.HBuilder.Hello.plugins;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.fanmaoyu.scsdk.SCStatisticsSDK;

import org.json.JSONArray;

import java.io.IOException;

import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.DHInterface.StandardFeature;
import io.dcloud.common.util.JSUtil;

public class FMTools extends StandardFeature {
    public void registerSCSDK(IWebview pWebview, JSONArray array)
    {
        try {
            SCStatisticsSDK.registerSDK(getDPluginContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getUUID(IWebview pWebview, JSONArray array)
    {
        String uuid = SCStatisticsSDK.getUUID();
        return JSUtil.wrapJsVar(uuid,true);
    }

    public void openURL(IWebview pWebview, JSONArray array)
    {
        String url = array.optString(0);

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri content_url = Uri.parse(url);
        intent.setData(content_url);

        Activity activity = pWebview.getActivity();
        activity.startActivity(Intent.createChooser(intent, "请选择浏览器"));

    }
}
