import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import zhiyuanzhezhaomu from '@/views/modules/zhiyuanzhezhaomu/list'
    import aboutus from '@/views/modules/aboutus/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import discusszhiyuanzhezhaomu from '@/views/modules/discusszhiyuanzhezhaomu/list'
    import discusszhiyuanzhehuodong from '@/views/modules/discusszhiyuanzhehuodong/list'
    import zhiyuanzhebaoming from '@/views/modules/zhiyuanzhebaoming/list'
    import zhiyuanzhehuodong from '@/views/modules/zhiyuanzhehuodong/list'
    import systemintro from '@/views/modules/systemintro/list'
    import huodongbaoming from '@/views/modules/huodongbaoming/list'
    import chat from '@/views/modules/chat/list'
    import bumenguanliyuan from '@/views/modules/bumenguanliyuan/list'
    import huodongpingjia from '@/views/modules/huodongpingjia/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '系统公告',
        component: news
      }
      ,{
	path: '/zhiyuanzhezhaomu',
        name: '志愿者招募',
        component: zhiyuanzhezhaomu
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
      ,{
	path: '/discusszhiyuanzhezhaomu',
        name: '志愿者招募评论',
        component: discusszhiyuanzhezhaomu
      }
      ,{
	path: '/discusszhiyuanzhehuodong',
        name: '志愿者活动评论',
        component: discusszhiyuanzhehuodong
      }
      ,{
	path: '/zhiyuanzhebaoming',
        name: '志愿者报名',
        component: zhiyuanzhebaoming
      }
      ,{
	path: '/zhiyuanzhehuodong',
        name: '志愿者活动',
        component: zhiyuanzhehuodong
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/huodongbaoming',
        name: '活动报名',
        component: huodongbaoming
      }
      ,{
	path: '/chat',
        name: '在线反馈',
        component: chat
      }
      ,{
	path: '/bumenguanliyuan',
        name: '部门管理员',
        component: bumenguanliyuan
      }
      ,{
	path: '/huodongpingjia',
        name: '活动评价',
        component: huodongpingjia
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
