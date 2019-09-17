<template>
    <div class="personaldate">
        <div class="title">
             <h1>我的川料</h1>
         </div>
         <div class="btn">
        <h3>提交</h3>
         </div>
          <div class="top_left">
                  <h2 class="to_bottom">姓名</h2><br>
                  <input type="text" name="name" autocomplete="off">
                   <h2 class="h2_dis">电话</h2><br>
                  <input type="text" name="name" autocomplete="off">
             
          </div>
         <div class="top_right">
              <h2 class="to_bottom">邮箱</h2><br>
                  <input type="text" name="name" autocomplete="off">
                  <h2 class="to_bottom2">性别</h2><br>
                  <select name="" id="">
                      <option value="男">男</option>
                      <option value="女">女</option>
                  </select>
         </div>
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="scss" scoped>
.btn{
    position: absolute;
    margin: 0 auto;
    left: 50%;
    margin-left: -100px;
    top:500px;
    height: 50px;
    width: 200px;
    border-radius: 25px;
    background-color: #d73430;
    line-height: 50px;
    cursor: pointer;
    
}
h3{
    font-size: 25px;
    color: white;
    margin-left: 34%;
}
.to_bottom2{
    margin-top: 50px;
    margin-left: 150px;
}
.to_bottom{
    margin-top: 200px;
    margin-left: 150px;
}
.h2_dis{
    margin-top: 50px;
    margin-left: 150px;
}
.top_left{
    width: 500px;
    height: 700px;
    // border: 1px solid red;
    position: absolute;
    left: 0;
}
.top_right{
     width: 500px;
    height: 700px;
    // border: 1px solid black;
    position: absolute;
    right: 0;
}
.personaldate{
    width: 100%;
    height: 800px;
    position: relative;
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
    font-weight: 700;
}
input{
    height: 30px;
    width: 250px;
    border: 1px solid gray;
    margin-left: 150px;
}
select{
    width: 250px;
    height: 30px;
    border: 1px solid gray;
     margin-left: 150px;
}
</style>