import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import bumenguanliyuanList from '../pages/bumenguanliyuan/list'
import bumenguanliyuanDetail from '../pages/bumenguanliyuan/detail'
import bumenguanliyuanAdd from '../pages/bumenguanliyuan/add'
import xueshengList from '../pages/xuesheng/list'
import xueshengDetail from '../pages/xuesheng/detail'
import xueshengAdd from '../pages/xuesheng/add'
import zhiyuanzhezhaomuList from '../pages/zhiyuanzhezhaomu/list'
import zhiyuanzhezhaomuDetail from '../pages/zhiyuanzhezhaomu/detail'
import zhiyuanzhezhaomuAdd from '../pages/zhiyuanzhezhaomu/add'
import zhiyuanzhebaomingList from '../pages/zhiyuanzhebaoming/list'
import zhiyuanzhebaomingDetail from '../pages/zhiyuanzhebaoming/detail'
import zhiyuanzhebaomingAdd from '../pages/zhiyuanzhebaoming/add'
import zhiyuanzhehuodongList from '../pages/zhiyuanzhehuodong/list'
import zhiyuanzhehuodongDetail from '../pages/zhiyuanzhehuodong/detail'
import zhiyuanzhehuodongAdd from '../pages/zhiyuanzhehuodong/add'
import huodongbaomingList from '../pages/huodongbaoming/list'
import huodongbaomingDetail from '../pages/huodongbaoming/detail'
import huodongbaomingAdd from '../pages/huodongbaoming/add'
import huodongpingjiaList from '../pages/huodongpingjia/list'
import huodongpingjiaDetail from '../pages/huodongpingjia/detail'
import huodongpingjiaAdd from '../pages/huodongpingjia/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'bumenguanliyuan',
					component: bumenguanliyuanList
				},
				{
					path: 'bumenguanliyuanDetail',
					component: bumenguanliyuanDetail
				},
				{
					path: 'bumenguanliyuanAdd',
					component: bumenguanliyuanAdd
				},
				{
					path: 'xuesheng',
					component: xueshengList
				},
				{
					path: 'xueshengDetail',
					component: xueshengDetail
				},
				{
					path: 'xueshengAdd',
					component: xueshengAdd
				},
				{
					path: 'zhiyuanzhezhaomu',
					component: zhiyuanzhezhaomuList
				},
				{
					path: 'zhiyuanzhezhaomuDetail',
					component: zhiyuanzhezhaomuDetail
				},
				{
					path: 'zhiyuanzhezhaomuAdd',
					component: zhiyuanzhezhaomuAdd
				},
				{
					path: 'zhiyuanzhebaoming',
					component: zhiyuanzhebaomingList
				},
				{
					path: 'zhiyuanzhebaomingDetail',
					component: zhiyuanzhebaomingDetail
				},
				{
					path: 'zhiyuanzhebaomingAdd',
					component: zhiyuanzhebaomingAdd
				},
				{
					path: 'zhiyuanzhehuodong',
					component: zhiyuanzhehuodongList
				},
				{
					path: 'zhiyuanzhehuodongDetail',
					component: zhiyuanzhehuodongDetail
				},
				{
					path: 'zhiyuanzhehuodongAdd',
					component: zhiyuanzhehuodongAdd
				},
				{
					path: 'huodongbaoming',
					component: huodongbaomingList
				},
				{
					path: 'huodongbaomingDetail',
					component: huodongbaomingDetail
				},
				{
					path: 'huodongbaomingAdd',
					component: huodongbaomingAdd
				},
				{
					path: 'huodongpingjia',
					component: huodongpingjiaList
				},
				{
					path: 'huodongpingjiaDetail',
					component: huodongpingjiaDetail
				},
				{
					path: 'huodongpingjiaAdd',
					component: huodongpingjiaAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
