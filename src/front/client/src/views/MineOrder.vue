<template>
    <div class="minemessage">
        <div class="title">
             <h1>我的川料</h1>
         </div>
         <div class="detail">
             <span>全部</span>
             <span>待付款</span>
             <span>待收货</span>
             <span>待评价</span>
         </div>
         <div class="gry">
             <div>订单详情</div>
             <div>收货人</div>
             <div>全部状态</div>
             <div>操作</div>
         </div>
         <div class="gry_2">
           <span>2019-9-17</span>
           <span>订单号：103010301003</span>
         </div>
         <div class="shop_detail">
             <div class="shop_one"></div>
              <div class="shop_two"></div>
               <div class="shop_three"></div>
         </div>
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="scss" scoped>
.minemessage{
    width: 100%;
    height: 800px;
    // margin-top: 60px;
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
.detail{
    margin-top: 50px;
    line-height: 40px;
    height: 40px;
    width: 100%;
    border-top:1px solid black;
    border-bottom: 1px solid black;
    display: flex;
    justify-content: space-around;
    
}
span{
    cursor: pointer;
    font-size: 20px;
   
}
span:hover{
     
        color: red;
    
}
.gry{
    width: 100%;
    height: 40px;
    margin-top: 25px;
    background-color: #F2F2F2;
    div{
        display: inline-block;
    }
    :nth-child(1){
        width: 49%;
        height: 100%;
       text-align: center;
       line-height: 40px;
    }
    :nth-child(2){
        width: 17%;
        height: 100%;
         text-align: center;
       line-height: 40px;
       
    }
    :nth-child(3){
        width: 17%;
        height: 100%;
         text-align: center;
       line-height: 40px;
       
    }
    :nth-child(4){
        width: 17%;
        height: 100%;
         text-align: center;
       line-height: 40px;
       
    }
}
.gry_2{
    height: 30px;
    width: 100%;
    background-color: #F2F2F2;
    margin-top: 15px;
    line-height: 30px;
    span:nth-child(1){
        font-size: 15px;
        color: #7E7E7E;
        margin-left: 15px;
    }
    span:nth-child(2){
         font-size: 15px;
        color: #7E7E7E;
        margin-left: 80px;
    }
}
.shop_detail{
    width: 100%;
    height: 150px;
    // border: 1px solid red;
    .shop_one{
        height: 100%;
        width: 49%;
        border-right: 1px solid black;
    }
    .shop_two{
        height: 100%;
        width: 17%;
        border-right: 1px solid black;
    }
}
</style>