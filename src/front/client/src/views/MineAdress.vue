<template>
    <div class="mineadress">
         <div class="title">
             <h1>我的川料</h1>
         </div>
         <h2>地址收藏</h2>
         <div class="msg_box">
             <h3>请添加所有您想要寄送的地址（你的家、工作地点、常住址...）</h3>
             <h3>这样您就不需要在每次下订单时填写寄送地址。</h3>
         </div>
         <div class="add_box" @click="jump">添加新地址</div>
         <div class="jumpbox" v-show="display">
             <div class="con_left">
             <input type="text" placeholder="收件人："><br>
             <input type="text" placeholder="详细地址：">
             </div>
             <div class="con_right">
                 <input type="text" placeholder="选择省/市/区"><br>
                 <VDistpicker class="selec"/>
             
             <input type="text" placeholder="电话：">
            
             </div>
              <div class="btn" @click="jumpback">保存并使用</div>
         </div>
    </div>

</template>

<script>
import VDistpicker from 'v-distpicker'

export default {
    components: { VDistpicker },
    data(){
        return{
            display:false
        }
    },
    methods:{
        jump(){
            this.display=true;
        },
        jumpback(){
            this.display=false
        }
    }

}

</script>

<style lang="scss" scoped>
.btn{
    width: 200px;
    height: 40px;
    background-color: #bf0000;
    color: white;
    position: absolute;
    text-align: center;
    line-height:40px;
    border-radius: 20px;
    left: 50%;
    margin-left: -100px;
    top:500px;
    cursor: pointer;
}
.con_right{
    // border: 1px solid red;
    width: 650px;
    position: absolute;
     top: 150px;
    right: -300px;
    
}
.con_left{
//      margin-top: 180px;
//    margin-left: 180px;
    // border: 1px solid red;
    width: 300px;
    position: absolute;
    top: 150px;
    left: 100px;
}
.add_box{
    height: 50px;
    width: 200px;
    border: 1px solid black;
    margin-left: 80px;
    margin-top: 100px;
    text-align: center;
    line-height: 50px;
     cursor: pointer;
}
.add_box:hover{
    
        background-color: #bf0000;
        color: white;
    
}
.mineadress{
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
h2{
    font-size: 30px;
    margin-top: 100px;
    margin-left: 80px;
}
h3{
    margin-top: 15px;
}
.msg_box{
    height: 50px;
    width: 500px;
    // border: 1px solid red;
    margin-left: 80px;
    margin-top: 50px;
}
.jumpbox{
    position: absolute;
    background-color: white;
    top:100px;
    width: 1000px;
    height: 600px;
    // border: 1px solid red
}
.con_left input{
  
   border-bottom: 2px solid black;
   width: 300px;
   margin-bottom: 180px;
}
.con_right input{
    
     border-bottom: 2px solid black;
   width: 300px;
}
.con_right input:last-child{
    margin-top: 140px;
}

</style>>

