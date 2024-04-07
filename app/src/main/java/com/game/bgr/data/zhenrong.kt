package com.game.bgr.data

/**
 * coco man
 * 2024/4/6
 **/

/**30-35阶说明：

山茶花6黑巧0石榴8金桂4德古拉6

打法:开局石榴亮了点金桂，吸血鬼亮了点山茶花，挂机到还剩20s取消一下自动等黑巧回位置继续自动打完

宝物:蓝卷 闹钟 弹弓


副词条注意:山茶花1.8到2的攻速，黑巧0攻速，石榴带增益效果加强，金桂吸血鬼高攻击**/



val dgl_0=ZhenRong(0,0,"山茶花石榴队", listOf<BingGan>(
    shanchahua.copy(tiaoliao = "攻击调料", cd = "6", remark = "副词条 1.8到2的攻速"),
    heiqiao.copy(tiaoliao = "攻击/伤害减免", cd = "0", remark = "根据个人饼干强度增加免伤，保证存活即可" ),
    jingui.copy(tiaoliao = "攻击", cd = "4", remark = "副词条 攻击"),
    degula.copy(tiaoliao = "攻击", cd = "6", remark = "副词条 攻击/会心"),
    shiliu.copy(tiaoliao = "攻击", cd = "8", remark = "副词条 增益效果加强")
),"","开局石榴亮了点金桂，吸血鬼亮了点山茶花，挂机到还剩20s取消一下自动等黑巧回位置继续自动打完",
    35,30,"蓝卷 闹钟 弹弓")

/**
 * 40阶后自爆队
 *
 * 阵容推荐：黑巧6，红丝绒8，金桂0高攻，吸血鬼0高会心，甘草0全攻击（死副词条换生命）
 *
 * 打法：黑巧劈刀手势点金桂，自动等甘草放完技能，德古拉技能亮的一瞬间手动点红丝绒，以上第一波打完了。
 * 第二波自动等黑巧金桂技能放完，沙漏红丝绒，甘草，吸血鬼哪里亮了点哪里
 */

val dgl_1=ZhenRong(1,0,"蛋糕龙高阶自曝队", listOf<BingGan>(
    hongsirong.copy(tiaoliao = "攻击", cd = "8", remark = ""),
    heiqiao.copy(tiaoliao = "攻击", cd = "6", remark = "" ),
    jingui.copy(tiaoliao = "攻击", cd = "0", remark = "副词条 攻击"),
    degula.copy(tiaoliao = "攻击", cd = "0", remark = "副词条 攻击/会心"),
    gancao.copy(tiaoliao = "攻击", cd = "0", remark = "")
),"","打法：黑巧劈刀手势点金桂，自动等甘草放完技能，德古拉技能亮的一瞬间手动点红丝绒，以上第一波打完了。\n" +
        " 第二波自动等黑巧金桂技能放完，沙漏红丝绒，甘草，吸血鬼哪里亮了点哪里",
    50,40,"蓝卷 闹钟 弹弓")






val dgl_2=ZhenRong(2,0,"山茶花低阶队", listOf(
    shanchahua.copy(tiaoliao = "攻击/免伤", cd = "6", remark = "根据实际情况更换免伤保证生存"),
    heiqiao.copy(tiaoliao = "攻击", cd = "0", remark = "副词条 攻速 根据实际情况增加免伤" ),
    jingui.copy(tiaoliao = "攻击", cd = "0", remark = "副词条 攻击不宜过高容易被反死，多带点伤害减免"),
    degula.copy(tiaoliao = "攻击", cd = "7.5-8", remark = "副词条 尽量拉高攻击/会心"),
    zimogu.copy(tiaoliao = "攻击", cd = "7.5-8", remark = "副词条多带免伤，攻击无所谓")
),"https://www.bilibili.com/video/BV1i1421Q7Nm?t=3.2","打法：开局沙漏蘑菇，金桂亮起点山茶花，开始挂机，倒数二十秒左右，山茶花技能亮起时，沙漏金桂，等弹弓转到最后一个角点黑巧蘑菇，然后挂机到结束。",
    20,1,"红卷 闹钟 弹弓")


val dgl_3=ZhenRong(3,0,"山茶花辣椒中阶自动队", listOf(
    shanchahua.copy(tiaoliao = "攻击/免伤", cd = "7.5", remark = "根据实际情况更换免伤保证生存"),
    heiqiao.copy(tiaoliao = "攻击", cd = "0", remark = "副词条 拉高攻速 根据实际情况增加免伤" ),
    jingui.copy(tiaoliao = "攻击", cd = "11", remark = "副词条 攻击不宜过高容易被反死，拉高伤害减免"),
    degula.copy(tiaoliao = "攻击", cd = "7.5-8", remark = "副词条 尽量拉高攻击/会心"),
    tianlajiang.copy(tiaoliao = "会心", cd = "3", remark = "拉高会心攻击")
),"https://www.bilibili.com/video/BV1Cq421w7iF/?share_source=copy_web",
    "打法：黑巧技能亮起后立刻点金桂，后续不需要任何操作。如果最后德古拉技能出不来可以尝试给德古拉附词条加一些攻速，",
    30,20,"红卷 闹钟 弹弓")

val dgl_4=ZhenRong(4,0,"山茶花辣椒中阶半自动队", listOf(
    shanchahua.copy(tiaoliao = "攻击/免伤", cd = "7.5", remark = "拉高伤害减免到20加"),
    heiqiao.copy(tiaoliao = "免伤", cd = "3", remark = "副词条 拉高攻速 根据实际情况增加免伤" ),
    jingui.copy(tiaoliao = "攻击/免伤", cd = "4.5", remark = "副词条 拉高伤害减免到20加"),
    degula.copy(tiaoliao = "攻击", cd = "大于4.5", remark = "副词条 尽量拉高攻击/会心"),
    tianlajiang.copy(tiaoliao = "会心", cd = "3", remark = "拉高会心攻击")
),"","打法：开局黑巧亮起秒点金桂，然后等甜辣酱释放两次技能之后，沙漏金桂，之后每次都是甜辣酱技能之后沙漏金桂",
    30,20,"红卷 闹钟 弹弓")
val dgl_5=ZhenRong(5,0,"石榴中阶简单操作队", listOf(
    shanchahua.copy(tiaoliao = "免伤", cd = "6", remark = ""),
    heiqiao.copy(tiaoliao = "免伤", cd = "0", remark = "副词条 攻速" ),
    jingui.copy(tiaoliao = "攻击", cd = "0", remark = "副词条 多带点伤害减免"),
    degula.copy(tiaoliao = "攻击", cd = "7.5-8", remark = "副词条 尽量拉高攻击/会心"),
    shiliu.copy(tiaoliao = "攻击", cd = "8", remark = "副词条多带免伤")
),"https://www.bilibili.com/video/BV1AC411L7cb?t=16.8","打法：开局沙漏金桂，石榴亮起后点山茶花",
    37,30,"红卷 闹钟 弹弓")
val dts_6=ZhenRong(6,1,"大天使低阶低配版樱花队", listOf(
    bohe.copy(tiaoliao = "攻击/冷却", cd = "12", remark = "副词条 凑够12冷却即可"),
    nongka.copy(tiaoliao = "攻击", cd = "5", remark = "副词条 cd最好正负不大于0.1，不要攻速" ),
    yinghua.copy(tiaoliao = "攻击/冷却", cd = "12", remark = "副词条 凑够12冷却"),
    heimei.copy(tiaoliao = "攻击", cd = "0", remark = "副词条 拉高攻速吃斗篷"),
    heimai.copy(tiaoliao = "攻击", cd = "3", remark = "副词条 拉高攻速吃斗篷")
),"https://www.bilibili.com/video/BV1Em411r7CS?t=59.5","打法：开局沙漏薄荷，然后沙漏樱花，之后挂机",
    30,1,"红卷 闹钟 攻速斗篷")
val dts_7=ZhenRong(7,1,"大天使低阶薄荷甘草队", listOf(
    bohe.copy(tiaoliao = "冷却", cd = "21", remark = "全冷却配料"),
    gancao.copy(tiaoliao = "攻击", cd = "8", remark = "副词条 拉高攻速吃斗篷" ),
    yinghua.copy(tiaoliao = "攻击/冷却", cd = "8", remark = "副词条 冷却凑够%8 优先其他饼干攻击配料"),
    heimei.copy(tiaoliao = "攻击", cd = "6", remark = "副词条 拉高攻击即可"),
    heimai.copy(tiaoliao = "攻击", cd = "4-6", remark = "副词条 拉高攻速吃斗篷")
),"https://www.bilibili.com/video/BV1UH4y1H7DA?t=79.3","打法：开局沙漏薄荷，然后沙漏樱花，之后挂机",
    30,1,"红卷 闹钟 攻速斗篷")

val dgl_8=ZhenRong(8,0,"蛋糕龙超高阶冷却流", listOf<BingGan>(
    hongsirong.copy(tiaoliao = "攻击", cd = "7-8", remark = "越高越稳定，不缺调料的情况最好达到8，如果7不影响打两轮也可以7"),
    heiqiao.copy(tiaoliao = "攻击", cd = "6", remark = "" ),
    jingui.copy(tiaoliao = "攻击", cd = "0", remark = "副词条 攻击"),
    degula.copy(tiaoliao = "攻击", cd = "0", remark = "副词条 攻击/会心"),
    gancao.copy(tiaoliao = "冷却", cd = "17-20", remark = "可以适当带攻击调料，满足冷却即可")
),"","打法：开局自动，先点沙漏甘草，自动黑巧然后马上点金桂，然后点沙漏甘草，弹弓到1秒点红丝绒吸血鬼，然后继续自动开出黑巧金桂，沙漏红丝绒，甘草吸血鬼，结束。",
    100,50,"蓝卷 闹钟 弹弓")



val listDgl= listOf<ZhenRong>(dgl_0, dgl_1, dgl_2, dgl_3, dgl_4, dgl_5, dts_6, dts_7, dgl_8)
