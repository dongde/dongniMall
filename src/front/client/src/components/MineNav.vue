<template>
  <div class="home-box">
    
    <ul>
      <div class="img-logo">
        <router-link :to="{name: 'home'}">
          <img src="@/assets/img/logo.png" alt="" class="logo">
        </router-link>
      </div>
      <li><router-link to="/PersonalDate"><div>个人资料</div></router-link></li>
      <li><router-link to="/MineOrder"><div>我的订单</div></router-link></li>
      <li><router-link to="/MineCheck"><div>我的发票</div></router-link></li>
      <li><router-link to="/MineAdress"><div>收获地址</div></router-link></li>
      <li><router-link to="/MineShopcar"><div>我的购物车</div></router-link></li>
      <li><router-link to="/MineMessage"><div>我的消息</div></router-link></li><br>
      
      <li><router-link to="">退出</router-link></li>
      <!-- <router-link
        tag="li"
        v-for="nav in navs"
        :key="nav.name"
        :to="nav.path"
      >
        <a>{{nav.meta.title}}</a>
      </router-link> -->
    </ul>
  </div>
</template>

<script>
// import routes from '@/router/routes'
// export default {
//   name: 'AppNav',
//   data () {
//     return {
//       navs: routes.filter(route => route.meta.isNav)
//     }
//   }
// }
</script>

<style lang="scss" scoped>
.home-box{
  display: flex;
}

.logo{
    width: 68px;
    height: 68px;
}

ul{
  position: relative;
  top: 0;
  left: 0;
  width: 150px;
  text-align: center;
  display: flex;
  flex-direction: column;

  .img-logo{
    margin-bottom: 30px;
  }

  li{
    a{
        border-radius: 1px;
        color: #262626;
        display: inline-block;
        height: 27px;
        line-height: 26px;
        padding: 1px 7px;
        margin: 4px 0;
        font-weight: 500;
        font-size: 18px;
    }

    :hover{
        background: #d73430;
        color: #fff;
        border-radius: 20px;
    }
  }

  .router-link-exact-active a, .router-link-active a{
    background: #d73430;
    color: #fff;
    border-radius: 20px;
  }

}

.li-box{
    width: 1030px;
    padding-top: 20px;
    // border: 1px solid red;
}
li{
    margin-top: 30px;
}
.router-link-exact-active div, .router-link-active div{
    width: 100px;
    background: #d73430;
    color: #fff;
    border-radius: 20px;
    
  }


</style>
