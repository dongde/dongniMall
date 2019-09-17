<template>
  <div>
    <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="美蛙鱼头底料" name="first">
          <ProductShow />
        </el-tab-pane>
        <el-tab-pane label="火锅底料" name="second">
          <ProductShow />
        </el-tab-pane>
        <el-tab-pane label="串串底料" name="third">
          <ProductShow />
        </el-tab-pane>
        <el-tab-pane label="冷锅鱼底料" name="fourth">
          <ProductShow />
        </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import ProductShow from '@/components/ProductShow'

export default {
  name: 'MaterialMall',
  components: {
    ProductShow
  },
  data () {
    return {
      activeName: 'first'
    }
  },
  methods: {
    handleClick (tab, event) {
      console.log(tab, event)
    }
  }
}
</script>

<style lang="scss">
.main{
  .el-tabs__item.is-active{
    background: #d73430;
    color: #fff;
    border-radius: 5px;
    border-bottom: none;
  }
  .el-tabs--top .el-tabs__item.is-top:nth-child(2){
    padding-left: 20px;
  }
  .el-tabs--top .el-tabs__item.is-top:last-child {
    padding-right: 20px;
  }
  .el-tabs__item{
    border: none;
    margin-right: 5px;

    &:hover{
      background: #d73430;
      color: #fff;
      border-radius: 5px;
      border: none;
    }
  }
  .el-tabs__active-bar{
      height: 0px;
  }
  .el-tabs__nav-wrap::after{
      height: 0px;
  }
}
</style>
