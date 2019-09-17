<template>
  <div class="common">
    <div class="order-con">
        <h2>我的购物篮</h2>
        <div class="order-list">
            <table class="order-form">
                <thead>
                    <tr>
                      <td><input type="checkbox" class="chk-all" checked> 全选</td>
                      <td colspan="2">商品名称</td>
                      <td>属性</td>
                      <td>单价</td>
                      <td>数量</td>
                      <td>小计</td>
                      <td>操作</td>
                    </tr>
                </thead>
                <tbody class="cart-tbody">
                  <tr v-for="list in lists" :key="list.id">
                    <td><input type="checkbox" class="chk-prod" checked="checked"></td>
                    <td class="img"><img :src="list.image"></td>
                    <td class="list-name">{{list.title}}</td>
                    <td class="size">{{list.size}}</td>
                    <td class="unit">￥{{list.price.toFixed(2)}}</td>
                    <td>
                        <div class="number">
                            <span class="num-sub">
                                <img src="@/assets/img/sub.png" class="sub">
                            </span>
                            <input type="text" class="tc num-num" :value="list.amount">
                            <span class="num-add">
                                <img  src="@/assets/img/add.png" class="add">
                            </span>
                        </div>
                    </td>
                    <td class="total-money">￥ {{(list.price*list.amount).toFixed(2)}}</td>
                    <td class="delete"><img src="@/assets/img/del.png"></td>
                  </tr>
                </tbody>
            </table>
            <div class="total-count">
                <span>商品总计:</span>
                <b>￥00.00</b>
            </div>
            <div class="cart-put">
                <router-link :to="{name: 'material'}">继续购买</router-link>
                <a href="/html/add.html" class="cart-buy">去结账</a>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
    name: 'Cart',
    data () {
      return {
        lists: [
          {
            amount: 1, 
            id: 3, 
            image: "http://img.maixiaobu.cn/kissmilan/product/20181112/1fe66945a91c613f.jpg",
            price: 198,
            size: "火锅底料",
            title: "Mango Mousse 芒果慕斯"
          },
          {
            amount: 1, 
            id: 5, 
            image: "http://img.maixiaobu.cn/kissmilan/product/20181112/1fe66945a91c613f.jpg",
            price: 198,
            size: "串串底料",
            title: "Mango Mousse 芒果慕斯"
          }
        ]
      }
    }
}
</script>

<style lang="scss">
.order-con {
  display: none;
  margin-right: auto;
  margin-left: auto;

  h2 {
    font-size: 24px;
    color: #666666;
    font-weight: 700;
    height: 44px;
  }

  .order-form {
    width: 100%;
    border-top: 1px solid #e8e0e0;
    color: #5b3937;
    text-align: center;

    thead {
      color: #666666;
      font-weight: 700;

      tr {
        height: 74px;
        line-height: 74px;

        td {
          background: url(../assets/img/line.png) no-repeat 100%;
        }
      }
    }

    tbody {
      tr{
        height: 190px;
        border-bottom: 1px solid #e8e0e0;
        vertical-align: middle;

        .img {
          width: 115px;

          img {
            width: 100px;
            height: 100px;
          }
        }

        .list-name {
          font-size: 18px;
        }

        .total-money {
          color: red;
        }

        .delete {
          cursor: pointer;
        }
      }

      td {
        border-bottom: 1px solid #e8e0e0;

        .number input {
          display: inline-block;
          width: 56px;
          height: 23px;
          line-height: 25px;
          border: 1px solid #979696;
          position: relative;
          top: 2px;
        }
      }
    }
  }

  .total-count {
    color: #666666;
    margin-top: 20px;
    margin-right: 100px;
    text-align: right;
  }

  .cart-put {
    margin: 40px 0 50px;
    text-align: right;

    &>a{
      display: inline-block;
      width: 312px;
      height: 39px;
      line-height: 39px;
      color: #000000;
      border: 1px solid #e0e0e0;
      text-align: center;
    }

    .cart-buy {
      color: white;
      border: none;
      margin-left: 20px;
      background: #bf0000;
    }
  }
}
</style>