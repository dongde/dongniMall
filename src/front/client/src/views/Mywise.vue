<template>
 <div class="mywise">
     <div class="title">
         <h1>我的川料</h1>
     </div>
     <div class="line_one">
         <div class="left"><router-link to="/PersonalDate">个人资料</router-link></div>
         <div class="right"><router-link to="/MineAdress">收货地址</router-link></div>
     </div>
     <div class="line_two">
         <div class="left"><span>用户名、电话、邮箱</span></div>
         <div class="right"><span>添加、删除地址、设置默认地址</span></div>
     </div>
     <div class="line_three">
         <div class="left"><router-link to="/MineOrder">我的订单</router-link></div>
         <div class="right"><router-link to="/MineShopcar">我的购物车</router-link></div>
     </div>
     <div class="line_four">
         <div class="left"><span>历史订单、订单情况查询</span></div>
         <div class="right"><span>我的购物车</span></div>
     </div>
     <div class="line_five">
         <div class="left"><router-link to="/MineCheck">我的发票</router-link></div>
         <div class="right"><router-link to="/MineMessage">我的消息</router-link></div>
     </div>
     <div class="line_six">
         <div class="left"><span>查看电子发票</span></div>
         <div class="right"><span>查看信息和通知</span></div>
     </div>
 </div>
</template>

<script>
export default{
    
}
</script>

<style scoped>
span{
    font-size: 20px;
    color: #727272
}
.left{
    height: 100%;
    width: 300px;
    /* border-right: 1px solid red; */
    float: left;
}
.right{
    height: 100%;
    width: 300px;
    /* border-left: 1px solid red; */
    float: right;
}
.mywise{
    width: 100%;
    height: 800px;
    /* margin-top: 60px; */
    /* border: 1px solid red; */
}
.title{
    width: 100%;
    text-align: center;
    font-weight: 700
    
}
h1{
    font-size: 40px;
}
.line_one,.line_two,.line_three,.line_four,.line_five,.line_six{
    width: 80%;
    /* border: 1px solid red; */
    height: 60px;
    margin-top: 30px;
    position: relative;
    margin-left: 15%
    
}
.line_one{
    margin-top: 60px;
}
a{
    color: black;
    font-size: 25px;
    font-weight: 700
    
}
</style>