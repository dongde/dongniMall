<template>
  <div class="formula common">
    <el-row class="mb">
      <el-col :span="10">
        <h3 class="common-title color1">视 频 介 绍</h3>
      </el-col>
      <el-col :span="4" :offset="10">
        <p class="sell-btn bg-color1 tc">
          <router-link :to="{name: 'sell'}">
            我要卖配方
          </router-link>
        </p>
      </el-col>
      <el-col :span="24" class="tc">
        <video controls="controls" autoplay="autoplay" width="60%" height="300px">
          <source src="movie.mp4" type="video/mp4">
          <source src="movie.ogg" type="video/ogg">
        </video>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="24" class="common-title">
        <el-select v-model="value" filterable>
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-col>
    </el-row>
    <ProductShow />
  </div>
</template>

<script>
import ProductShow from '@/components/ProductShow'
export default {
  name: 'FormulaTrading',
  components: {
    ProductShow
  },
  data () {
    return {
      options: [
        {
          value: '选项1',
          label: '黄金糕'
        },
        {
          value: '选项2',
          label: '双皮奶'
        },
        {
          value: '选项3',
          label: '蚵仔煎'
        },
        {
          value: '选项4',
          label: '龙须面'
        },
        {
          value: '选项5',
          label: '北京烤鸭'
        }
      ],
      value: '请选择'
    }
  }
}
</script>

<style lang="scss">
.formula{
  .common-title{
    font-size: 16px;
    padding-bottom: 20px;
  }
  .sell-btn{
    line-height: 36px;
    border-radius: 5px;
    margin-bottom: 20px;

    a{
      color: #fff;
    }
  }
  .el-input__inner{
    background-color: #bf0000;
    color: #ffffff;
  }
  .el-select .el-input .el-select__caret{
    font-size: 20px;
    color: #ffffff;
  }
  .el-select .el-input__inner:focus{
    border-color: #bf0000;
  }
}
</style>
