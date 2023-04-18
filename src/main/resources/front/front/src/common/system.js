export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["新增","查看","修改","删除"],"menu":"部门管理员","menuJump":"列表","tableName":"bumenguanliyuan"}],"menu":"部门管理员管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["新增","查看","修改","删除"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除","查看评论"],"menu":"志愿者招募","menuJump":"列表","tableName":"zhiyuanzhezhaomu"}],"menu":"志愿者招募管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","修改","删除"],"menu":"志愿者报名","menuJump":"列表","tableName":"zhiyuanzhebaoming"}],"menu":"志愿者报名管理"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["新增","查看","修改","删除","查看评论"],"menu":"志愿者活动","menuJump":"列表","tableName":"zhiyuanzhehuodong"}],"menu":"志愿者活动管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","修改","删除"],"menu":"活动报名","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"活动报名管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看","修改","删除"],"menu":"活动评价","menuJump":"列表","tableName":"huodongpingjia"}],"menu":"活动评价管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-keyboard","buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"系统公告","tableName":"news"},{"appFrontIcon":"cuIcon-service","buttons":["新增","查看","修改","删除"],"menu":"在线反馈","tableName":"chat"},{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","查看评论","报名"],"menu":"志愿者招募列表","menuJump":"列表","tableName":"zhiyuanzhezhaomu"}],"menu":"志愿者招募模块"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","查看评论","报名"],"menu":"志愿者活动列表","menuJump":"列表","tableName":"zhiyuanzhehuodong"}],"menu":"志愿者活动模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除","查看评论"],"menu":"志愿者招募","menuJump":"列表","tableName":"zhiyuanzhezhaomu"}],"menu":"志愿者招募管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","修改","删除","审核"],"menu":"志愿者报名","menuJump":"列表","tableName":"zhiyuanzhebaoming"}],"menu":"志愿者报名管理"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["新增","查看","修改","删除","查看评论"],"menu":"志愿者活动","menuJump":"列表","tableName":"zhiyuanzhehuodong"}],"menu":"志愿者活动管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","修改","删除","审核"],"menu":"活动报名","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"活动报名管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看","删除"],"menu":"活动评价","menuJump":"列表","tableName":"huodongpingjia"}],"menu":"活动评价管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","查看评论","报名"],"menu":"志愿者招募列表","menuJump":"列表","tableName":"zhiyuanzhezhaomu"}],"menu":"志愿者招募模块"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","查看评论","报名"],"menu":"志愿者活动列表","menuJump":"列表","tableName":"zhiyuanzhehuodong"}],"menu":"志愿者活动模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"部门管理员","tableName":"bumenguanliyuan"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","修改","删除"],"menu":"志愿者报名","menuJump":"列表","tableName":"zhiyuanzhebaoming"}],"menu":"志愿者报名管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","修改","删除","活动评价"],"menu":"活动报名","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"活动报名管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看","修改","删除"],"menu":"活动评价","menuJump":"列表","tableName":"huodongpingjia"}],"menu":"活动评价管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","查看评论","报名"],"menu":"志愿者招募列表","menuJump":"列表","tableName":"zhiyuanzhezhaomu"}],"menu":"志愿者招募模块"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","查看评论","报名"],"menu":"志愿者活动列表","menuJump":"列表","tableName":"zhiyuanzhehuodong"}],"menu":"志愿者活动模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"学生","tableName":"xuesheng"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
