<template>
  <div class="header content">
    <el-input
        placeholder="请输入内容"
        suffix-icon="el-icon-search"
        v-model="input"
        class="sreach-input"
    >
    </el-input>
    <div class="cart">
        <router-link :to="{name: 'cart'}" class="el-icon-shopping-cart-2">
            购物车
        </router-link>
    </div>
    <div class="header-passport">
        <a href="#" class="login" @click="dialogFormVisible = true"><span>登录</span></a>
        <i class="line">|</i>
        <a href="#" class="resgister" @click="dialogFormVisible = true"><span>注册</span></a>
    </div>

    <el-dialog :visible.sync="dialogFormVisible" width="34%">
        <Model></Model>
    </el-dialog>
  </div>
</template>

<script>
import Model from '@/components/Model'

export default {
    name: 'AppHeader',
    components: {
        Model
    },
    data() {
        return {
            input: '',
            dialogFormVisible: false,
        }
    }
}
</script>

<style lang="scss" scoped>
.header{
  display: flex;
  justify-content: flex-end;
  margin-bottom: 8px;

  .sreach-input{
    width: 200px;
    margin-right: 5px;
  }

  .cart a, .header-passport, .header-passport span{
    line-height: 40px;
    background: #bf0000;
    color: #fff;
    font-size: 14px;
    padding: 0 8px;
    border-radius: 5px;
  }

  .cart{
      margin-right: 5px;
  }
}
</style>
