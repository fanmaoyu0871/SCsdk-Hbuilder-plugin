//
//  FMTools.m
//  HBuilder
//
//  Created by 范茂羽 on 2018/5/29.
//  Copyright © 2018年 DCloud. All rights reserved.
//

#import "FMTools.h"
#import <SCsdk/SCsdk.h>

@implementation FMTools

-(void)registerSCSDK:(PGMethod*)command{
    [SCStatisticsSDK registerSDK];
}

-(NSData*)getUUID:(PGMethod*)command{

    NSString *uuid = [SCStatisticsSDK getUUID];
    return [self resultWithString: uuid];
}

-(NSData*)getIDFA:(PGMethod*)command{
    
    NSString *uuid = [SCStatisticsSDK getIDFA];
    return [self resultWithString: uuid];
}

-(void)openURL:(PGMethod*)command{
    NSString* url = [command.arguments objectAtIndex:0];
    
    NSURL *cleanURL = [NSURL URLWithString:url];
    [[UIApplication sharedApplication] openURL:cleanURL];
}

@end
