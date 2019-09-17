<template>
<div class="propaganda">
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="说明" name="first">
     <img src="../assets/img/img1.jpg" alt="" width="1000px"  height="500ox" style="margin-top:10px;">
    </el-tab-pane>
    <el-tab-pane label="菜单" name="second" class="poster" >
      <div class="first">
      <div class="two">  <img src="../assets/describe/07.jpg" alt="" width="100%" height="100%"></div>
      <div class="three">      <img src="../assets/describe/01.jpg" alt="" width="100%" height="100%"></div>
      <div class="four">       <img src="../assets/describe/04.jpg" alt="" width="100%" height="100%"></div>
      <div class="five"> <img src="../assets/describe/14.jpg" alt="" width="100%" height="100%"></div>
      <div class="six">        <img src="../assets/describe/02.jpg" alt="" width="100%" height="100%"></div>
      <div class="seven">      <img src="../assets/describe/07.jpg" alt="" width="100%" height="100%"></div>
      <div class="eight"><img src="../assets/describe/13.jpg" alt="" width="100%" height="100%"></div>
      <div class="nine">       <img src="../assets/describe/02.jpg" alt="" width="100%" height="100%"></div>
      <div class="ten">        <img src="../assets/describe/10.jpg" alt="" width="100%" height="100%"></div>
    </div>
    </el-tab-pane>
    <el-tab-pane label="传单" name="third" class="poster">
      <div class="first">
      <div class="two">  <img src="../assets/describe/02.jpg" alt="" width="100%" height="100%"></div>
      <div class="three">      <img src="../assets/describe/01.jpg" alt="" width="100%" height="100%"></div>
      <div class="four">       <img src="../assets/describe/05.jpg" alt="" width="100%" height="100%"></div>
      <div class="five"> <img src="../assets/describe/14.jpg" alt="" width="100%" height="100%"></div>
      <div class="six">        <img src="../assets/describe/09.jpg" alt="" width="100%" height="100%"></div>
      <div class="seven">      <img src="../assets/describe/07.jpg" alt="" width="100%" height="100%"></div>
      <div class="eight"><img src="../assets/describe/13.jpg" alt="" width="100%" height="100%"></div>
      <div class="nine">       <img src="../assets/describe/08.jpg" alt="" width="100%" height="100%"></div>
      <div class="ten">        <img src="../assets/describe/10.jpg" alt="" width="100%" height="100%"></div>
    </div>
    </el-tab-pane>
    <el-tab-pane label="海报" name="fourth" class="poster">
    <div class="first">
      <div class="two">  <img src="../assets/describe/03.jpg" alt="" width="100%" height="100%"></div>
      <div class="three">      <img src="../assets/describe/01.jpg" alt="" width="100%" height="100%"></div>
      <div class="four">       <img src="../assets/describe/04.jpg" alt="" width="100%" height="100%"></div>
      <div class="five"> <img src="../assets/describe/14.jpg" alt="" width="100%" height="100%"></div>
      <div class="six">        <img src="../assets/describe/09.jpg" alt="" width="100%" height="100%"></div>
      <div class="seven">      <img src="../assets/describe/07.jpg" alt="" width="100%" height="100%"></div>
      <div class="eight"><img src="../assets/describe/13.jpg" alt="" width="100%" height="100%"></div>
      <div class="nine">       <img src="../assets/describe/02.jpg" alt="" width="100%" height="100%"></div>
      <div class="ten">        <img src="../assets/describe/10.jpg" alt="" width="100%" height="100%"></div>
    </div>

    </el-tab-pane>
  </el-tabs>
  </div>
</template>

<script>
export default {
  
  
  name: 'Propaganda',
  data () {
    return {
      activeName: 'first'
    }
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    }
  }
}
</script>

<style lang="scss">
.first .two{
  height: 250px;
  left: 325px;
}
.first .three{
  height: 300px;
  left:650px;
}
.first .four{
  height:290px ;
  top: 225px;
}
.first .five{
  height: 230px;
  top:540px;
}
.first .six{
  left: 325px;
  top:275px;
}
.first .seven{
  left: 325px;
  top:500px;
  height: 270px;
}
.first .eight{
  left: 650px;
  height: 260px;
  top:325px;
}
.first .nine{
  left: 650px;
  top:610px;
  height: 160px;
}
.first div{
  position: absolute;
  display:inline-block;
  height: 200px;
  width: 300px;
  // margin-bottom: 15px;
  // margin-right: 15px;
  overflow: hidden;

  background-color: red
}
.poster .first{
  position: relative;
  height: 1000px;
  width: 1000px;
  // scroll-behavior: auto
  // background-color: #99a9bf;
}
.line_three{
  // margin-left: 20px;
}
.line_two{
  // margin-left: 100px;
}
.propaganda{
  // position: relative;
  height: 1000px;
  margin-top:50px;
  
}
.imgs img{
  // position: absolute
  margin-right: 15px;
  margin-bottom: 15px;
}
 .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>
