<template>
  <div class="sc-footer ">
        <div class="footer-content">
            <div class="footer-wrapper clearfix">
                <div class="contract-wrap">
                    <div class="company">
                        <router-link tag="p" :to="{name: 'home'}">
                            <img class="logo" src="@/assets/img/logo.png" alt="">
                        </router-link>
                        <!-- <p><img class="logo" src="@/assets/img/logo.png" alt=""></p> -->
                        <p>成都川料智选科技有限公司</p>
                        <p>地址：成都市武侯区科华北路99号四川大学国家大学科技园</p>
                        <p>电话：028-85533714/400-8852078</p>
                    </div>
                    <div class="contract">
                        <p>销售：杨经理 电话：19980717690 </p>
                        <p>技术：寇师傅 电话：17323090713</p>
                        <p>投诉：刘经理 电话：18280000544</p>
                    </div>
                </div>
                <div class="content" style="color: darkgrey">©<span id="fyear"> 2018 </span><span>川料智选</span> 版权所有 技术支持：<a href="https://dongni.net/" style="color: darkgray">成都懂你科技有限公司</a></div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'AppFooter'
}
</script>

<style lang="scss" scoped>
.sc-footer {
    margin-top: 96px;
    background: #2d3237;
    position: relative;
    width: 100%;
    z-index: 1000;

    .footer-content {
        background: #2d3237;
        margin: 0 auto;
        width: 1030px;
    }

    .contract-wrap {
        position: relative;
        color: #fff;
        font-size: 12px;
    }

    .company {
        display: inline-block;
        opacity: .7;
        margin-top: 30px;
        margin-bottom: 30px;

        .logo {
            width: 60px;
            margin-bottom: 16px;
        }

        p {
            margin-bottom: 14px;
        }
    }

    .contract {
        display: inline-block;
        margin-left: 400px;
        opacity: .7;

        p {
            margin-bottom: 14px;
        }
    }
}

.footer-wrapper {
    padding-bottom: 17px;
    padding-top: 17px;
    position: relative;

    .footer-logo {
        display: inline-block;
        vertical-align: middle;
    }

    .content {
        color: #ccc;
        font-size: 12px;
        color: #666;
        line-height: 24px;
        text-align: left;

        span{
            font-size: 14px;
        }
    }
}
</style>