<template>
  <div class="formula-show">
        <el-row>
            <el-col 
                :span="7"
                :offset="1"
                v-for="list in lists"
                :key="list.id"
                class="formula-picture mb"
            >
                <div class="produce-img mb">
                    <img src="@/assets/img/new.png" alt="">
                </div>
                <div class="product-info">
                    <p class="product-detail">
                        <router-link :to="{name: 'home'}">{{list.title}}</router-link>
                    </p>
                    <!-- <p class="product-detail">
                        <router-link :to="{name: 'home'}">{{list.label}}</router-link>
                    </p> -->
                    <p class="product-price color1">
                        <span>{{list.price}} 元</span>
                        <!-- <span><i class="el-icon-plus"></i>确认购买</span> -->
                    </p>
                </div>
            </el-col>
        </el-row>
        <el-row>
            <el-pagination
                background
                layout="prev, pager, next"
                :page-size="8"
                :total="lists.length"
                :hide-on-single-page="value"
            >
            </el-pagination>
        </el-row>
  </div>
</template>

<script>
export default {
    name: 'ProductShow',
    data () {
        return {
            value:true,
            lists: [
                {
                    id: 1, title: '美蛙鱼底料配方', label: '美味', price: 150
                },
                {
                    id: 2, title: '美蛙鱼底料配方', label: '美味', price: 150
                },
                {
                    id: 3, title: '美蛙鱼底料配方', label: '美味', price: 150
                },
                {
                    id: 4, title: '美蛙鱼底料配方', label: '美味', price: 150
                },
                {
                    id: 5, title: '美蛙鱼底料配方', label: '美味', price: 150
                }
            ]
        }
    }
}
</script>

<style lang="scss">
.formula-show{
    .formula-picture{
        .produce-img{
            height: 300px;

            img{
                width: 100%;
                height: 100%;
            }
        }

        .product-detail a{
            font-size: 16px;
            color: #373737;
            line-height: 25px;
        }

        .product-price{
            display: flex;
            justify-content: space-between;

            span{
                font-size: 14px;
                line-height: 30px;
            }
        }
    }
}
.el-pagination.is-background .el-pager li:not(.disabled).active{
    background-color: #bf0000;
}
.el-pagination.is-background .el-pager li:not(.disabled):hover{
    color: #bf0000;
} 
</style>
