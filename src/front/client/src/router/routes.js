import Home from '@/views/Home'
import AppNav from '@/components/AppNav'
import AppFooter from '@/components/AppFooter'
import News from '@/views/News'
import Propaganda from '@/views/Propaganda'
import Teaching from '@/views/Teaching'
import FormulaTrading from '@/views/FormulaTrading'
import MaterialMall from '@/views/MaterialMall'
import Cart from '@/views/Cart'
import Mywise from '@/views/Mywise'
import MineNav from '@/components/MineNav'
import MineAdress from '@/views/MineAdress'
import MineCheck from '@/views/MineCheck'
import MineMessage from '@/views/MineMessage'
import MineOrder from '@/views/MineOrder'
import MineShopcar from '@/views/MineShopcar'
import PersonalDate from '@/views/PersonalDate'

import Sell from '@/components/Sell'

export default [
  {
    path:'/MineAdress',
    components:{
          default:MineAdress,
          aside:MineNav,
          footer:AppFooter
    },
    meta:{
      isNav:false
    }

  },
  {
    path:'/PersonalDate',
    components:{
          default:PersonalDate,
          aside:MineNav,
          footer:AppFooter
    },
    meta:{
      isNav:false
    }

  },
  {
    path:'/MineCheck',
    components:{
          default:MineCheck,
          aside:MineNav,
          footer:AppFooter
    },
    meta:{
      isNav:false
    }

  },
  {
    path:'/MineMessage',
    components:{
          default:MineMessage,
          aside:MineNav,
          footer:AppFooter
    },
    meta:{
      isNav:false
    }

  },
  {
    path:'/MineOrder',
    components:{
          default:MineOrder,
          aside:MineNav,
          footer:AppFooter
    },
    meta:{
      isNav:false
    }

  },
  {
    path:'/MineShopcar',
    components:{
          default:MineShopcar,
          aside:MineNav,
          footer:AppFooter
    },
    meta:{
      isNav:false
    }

  },
  {
    path: '/',
    redireact: '/home',
    meta: {
      isNav: false
    }
  },
  {
    path: '/Mywise',
    name:'Mywise',
    components:{
      default:Mywise,
      aside:MineNav,
      footer:AppFooter
    },
    meta: {
      isNav: false,
      title: "我的川料"
    }
  },
  {
    path: '/home',
    name: 'home',
    components: {
      default: Home,
      aside: AppNav,
      footer: AppFooter,
      
    },
    meta: {
      isNav: true,
      title: '首页'
    }
  },
  {
    path: '/news',
    name: 'news',
    components: {
      default: News,
      aside: AppNav,
      footer: AppFooter
    },
    meta: {
      isNav: true,
      title: '新闻资讯'
    }
  },
  {
    path: '/propaganda',
    name: 'propaganda',
    components: {
      default: Propaganda,
      aside: AppNav,
      footer: AppFooter
    },
    meta: {
      isNav: true,
      title: '宣传模板'
    }
  },
  {
    path: '/teaching',
    name: 'teaching',
    components: {
      default: Teaching,
      aside: AppNav,
      footer: AppFooter
    },
    meta: {
      isNav: true,
      title: '教学视频'
    }
  },
  {
    path: '/formulatrading',
    name: 'formulatrading',
    components: {
      default: FormulaTrading,
      aside: AppNav,
      footer: AppFooter
    },
    meta: {
      isNav: true,
      title: '配方交易'
    }
  },
  {
    path: '/sell',
    name: 'sell',
    components: {
      default: Sell,
      aside: AppNav,
      footer: AppFooter
    },
    meta: {
      isNav: false
    }
  },
  {
    path: '/material',
    name: 'materialmall',
    components: {
      default: MaterialMall,
      aside: AppNav,
      footer: AppFooter
    },
    meta: {
      isNav: true,
      title: '底料商城'
    }
  },
  {
    path: '/cart',
    name: 'cart',
    components: {
      default: Cart,
      aside: AppNav,
      footer: AppFooter
    },
    meta: {
      isNav: false
    }
  }
]
