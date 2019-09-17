<template>
    <div class="news-box">
      <div class="new-title">
          <h3>新闻推荐</h3>
      </div>
      <div v-for="list in 3" :key="list.id">
            <div class="new-content">
                <div class="new-img">
                    <img src="@/assets/img/new.png" alt="">
                </div>
                <div class="new-text">
                        <p class="template-title">
                            <a href="#">2025年火锅底料市场规模有望超400亿 行业竞争格局分散
                            </a>
                        </p>
                        <p class="template-content">
                            <a href="#">随着火锅业的崛起，火锅底料产业迅速发展，产业规模不断扩大。2014年火锅底料市场规模突破百亿，2018年市场规模逼近200亿元，预计2025年市场规模将超400亿元。
                            </a>
                        </p>
                        <p class="template-bar">
                            <span class="template-from">来自主题：<a href="#">中商产业研究院</a></span>
                            <span class="template-time"><i class="el-icon-time"></i>2019-08-15</span>
                        </p>
                </div>
            </div>
      </div>
  </div>
</template>

<script>
export default {
    name: 'NewsTemplate'
}
</script>

<style lang="scss" scoped>
.news-box{
    padding-top: 40px;

    .new-title{
        color: #262626;
        font-size: 24px;
        line-height: 33px;
        padding-bottom: 14px;
        font-weight: 500;
    }

    .new-content{
        margin-bottom: 30px;
        width: 100%;
        cursor: pointer;
        display: flex;
        height: 143px;

        .new-img{
            width: 216px;
            height: 100%;
            overflow: hidden;

            img{
                height: 100%;
                transition: all 1s;
                transform: scale(1);
            }
        }

        .new-text{
            height: 100%;
            margin-left: 20px;
            position: relative;
            width: calc(100% - 236px);

            .template-title{
                line-height: 24px;
                margin-top: 8px;
                margin-bottom: 10px;
                max-height: 48px;

                a{
                    color: #262626;
                    font-size: 18px;
                    text-align: justify;
                    transition: .5s;

                    &:hover{
                        color: #4285f4;
                    }
                }
            }

            .template-content a{
                color: #787878;
                font-size: 13px;
                letter-spacing: 0;
                line-height: 20px;
                margin-top: 10px;
                max-height: 40px;

                &:hover{
                    color: #797979;
                }
            }

            .template-bar{
                bottom: 2px;
                color: #a7a7a7;
                float: left;
                font-size: 12px;
                line-height: 18px;
                position: absolute;
                width: 100%;

                .template-from{
                    padding-right: 6px;

                    a{
                        color: #007bff;
                    }
                }

                .template-time{
                    float: right;
                    padding-left: 5px;
                }
            }
        }
    }
}
</style>
