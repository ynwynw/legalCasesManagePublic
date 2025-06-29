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
    import anjianxinxi from '@/views/modules/anjianxinxi/list'
    import yuangong from '@/views/modules/yuangong/list'
    import yuangongtixing from '@/views/modules/yuangongtixing/list'
    import yonghu from '@/views/modules/yonghu/list'
    import shiwusuoxinxi from '@/views/modules/shiwusuoxinxi/list'
    import yonghutixing from '@/views/modules/yonghutixing/list'
    import anjianzhengju from '@/views/modules/anjianzhengju/list'
    import anjiantongji from '@/views/modules/anjiantongji/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
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
	path: '/anjianxinxi',
        name: '案件信息',
        component: anjianxinxi
      }
      ,{
	path: '/yuangong',
        name: '员工',
        component: yuangong
      }
      ,{
	path: '/yuangongtixing',
        name: '员工提醒',
        component: yuangongtixing
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/shiwusuoxinxi',
        name: '事务所信息',
        component: shiwusuoxinxi
      }
      ,{
	path: '/yonghutixing',
        name: '用户提醒',
        component: yonghutixing
      }
      ,{
	path: '/anjianzhengju',
        name: '案件证据',
        component: anjianzhengju
      }
      ,{
	path: '/anjiantongji',
        name: '案件统计',
        component: anjiantongji
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
    name: '首页',
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

export default router;
