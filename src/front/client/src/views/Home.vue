<template>
  <div class="common">
    <el-row :gutter="20" class="block">
        <!-- 轮播 -->
        <el-col :span="16">
            <div class="banner">
                <el-carousel trigger="click">
                    <el-carousel-item v-for="item in 3" :key="item">
                        <h3 class="small">{{ item }}</h3>
                    </el-carousel-item>
                </el-carousel>
            </div>
        </el-col>
        <!-- 轮播旁的图片 -->
        <el-col :span="8">
            <div class="grid-content bg-purple">
                <el-row :gutter="20" class="banner-right">
                    <el-col :span="12">
                        <div class="grid-content bg-purple-dark">
                        </div>
                    </el-col>
                    <el-col :span="12">
                        <div class="grid-content bg-purple-dark"></div>
                    </el-col>
                </el-row>
                <el-row :gutter="20" class="banner-right">
                    <el-col :span="12">
                        <div class="grid-content bg-purple-dark">
                        </div>
                    </el-col>
                    <el-col :span="12">
                        <div class="grid-content bg-purple-dark"></div>
                    </el-col>
                </el-row>
            </div>
        </el-col>
    </el-row>
    <!-- 最新文章 -->
    <div class="news">
        <NewsTemplate />
    </div>
  </div>
</template>

<script>
import NewsTemplate from '@/components/NewsTemplate'

export default {
    name: 'Home',
    components: {
        NewsTemplate
    }
}
</script>

<style lang="scss" scoped>
.common{
  .block{
      height: 300px;

      .banner{
          border-radius: 4px;
      }

      .banner-right{
          height: 145px;
          margin-bottom: 10px;
      }
  }
}

.el-col {
    border-radius: 4px;
}
.bg-purple-dark {
    background: red;
}
.grid-content {
    height: 145px;
    border-radius: 4px;
    min-height: 36px;
}
.row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
}

// 走马灯
.el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
}

.el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
}
</style>
