## Hbuilder集合SCsdk上的插件

首先，到 https://github.com/fanmaoyu0871/SCsdk-Hbuilder-plugin 下载，下载下来的内容包含了iOS和Android两个项目，这两个项目是我从Hbuilder官网上下载的，已经经过一些简单处理，能直接运行起来。

*  <h1>iOS</h1>

### 1.下载项目，用xcode打开，然后先用模拟器运行项目，看看有没有问题，如图：

<img src="https://github.com/fanmaoyu0871/SCsdk-Hbuilder-plugin/blob/master/xcode-use_4.jpeg" />

### 2.确定该项目可以运行后，然后把www下的所有文件删除，然后把你们的文件拖到www下，完成后的目录文件结构，跟之前还是一样的，如图：

<img src="https://github.com/fanmaoyu0871/SCsdk-Hbuilder-plugin/blob/master/xcode-use_1.jpeg" />

### 3.把之前index.html里的脚本放到现在的index.html的最后，如图：

<img src="https://github.com/fanmaoyu0871/SCsdk-Hbuilder-plugin/blob/master/xcode-use_2.jpeg" />

### 4.在manifest.json中添加插件，如图：

<img src="https://github.com/fanmaoyu0871/SCsdk-Hbuilder-plugin/blob/master/xcode-use_3.jpeg" />

*  <h1>Android</h1>
### 1.下载项目，用android studio打开，然后直接用真机运行项目，看看有没有问题，如图：

<img src="https://github.com/fanmaoyu0871/SCsdk-Hbuilder-plugin/blob/master/android_use_1.jpeg" />

### 2.确定该项目可以运行后，然后把www下的所有文件删除，然后把你们的文件拖到www下，完成后的目录文件结构，跟之前还是一样的；把之前index.html里的脚本放到现在的index.html的最后如图：

<img src="https://github.com/fanmaoyu0871/SCsdk-Hbuilder-plugin/blob/master/android_use_2.jpeg" />

### 3.在manifest.json中添加插件，如图：

<img src="https://github.com/fanmaoyu0871/SCsdk-Hbuilder-plugin/blob/master/android_use_3.jpeg" />


## 最后说一下，在你们前端项目中如何调用这个插件：

* 这段代码是在index.html加入的代码，Android和iOS都是一样的:
```
  <script type=text/javascript>
            document.addEventListener("plusready",  function(){
                    // 声明的JS“扩展插件别名”
                    var _BARCODE = 'FMTools',
                    B = window.plus.bridge;
                    var FMTools ={
                        // 声明同步返回方法
                        getUUID : function (){
                            return B.execSync(_BARCODE, "getUUID", []);
                        },           
                        registerSCSDK : function (){
                            return B.execSync(_BARCODE, "registerSCSDK", []);
                        }
                    };
                    window.plus.FMTools = FMTools;
            }, true);
                                      
            function registerSDK(){
                plus.FMTools.registerSCSDK();
            }
        
            function getUUID(){
                var uuid = plus.FMTools.getUUID();
                alert(uuid);
            }
        </script>
```

* 你们只需要在前端代码中先调用 `plus.FMTools.registerSCSDK();`来注册sdk， 然后在js任意处调用 `var uuid = plus.FMTools.getUUID();` 这个uuid就是统一的设备唯一标示

# 备注: 上面的两个调用顺序不能错，其中`plus.FMTools.registerSCSDK();`只用在程序一开始调用1次，`plus.FMTools.getUUID();`可以任意调用
