//
//  FMTools.h
//  HBuilder
//
//  Created by 范茂羽 on 2018/5/29.
//  Copyright © 2018年 DCloud. All rights reserved.
//

#import "PGPlugin.h"
#import "PGMethod.h"

@interface FMTools : PGPlugin

-(void)registerSCSDK:(PGMethod*)command;

-(NSData*)getUUID:(PGMethod*)command;

@end
