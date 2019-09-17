<template>
  <div>
    <el-row :gutter="20">
      <el-col
        :span="8"
        v-for="list in lists"
        :key="list.id"
      >
        <router-link :to="{name: 'home'}" class="template-img">
          <img src="@/assets/img/img1.jpg" alt="">
          <span class="el-icon-caret-right"></span>
        </router-link>
        <router-link :to="{name: 'home'}" class="template-title">
          {{list.title}}
        </router-link>
        <p class="template-detail mb">{{list.detail}}</p>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'Teaching',
  data () {
    return {
      lists: [
        {
          id: 1,
          title: '不管是寒冷的冬天，还是炎热的夏天，我们家都特别喜欢吃火锅！',
          detail: '吃火锅是最原始的做法，想吃什么就放什么，好自在的说！'
        },
        {
          id: 2,
          title: '不管是寒冷的冬天，还是炎热的夏天，我们家都特别喜欢吃火锅！',
          detail: '吃火锅是最原始的做法，想吃什么就放什么，好自在的说！'
        },
        {
          id: 3,
          title: '不管是寒冷的冬天，还是炎热的夏天，我们家都特别喜欢吃火锅！',
          detail: '吃火锅是最原始的做法，想吃什么就放什么，好自在的说！'
        },
        {
          id: 4,
          title: '不管是寒冷的冬天，还是炎热的夏天，我们家都特别喜欢吃火锅！',
          detail: '吃火锅是最原始的做法，想吃什么就放什么，好自在的说！'
        },
        {
          id: 5,
          title: '不管是寒冷的冬天，还是炎热的夏天，我们家都特别喜欢吃火锅！',
          detail: '吃火锅是最原始的做法，想吃什么就放什么，好自在的说！'
        }
      ]
    }
  }
}
</script>

<style lang="scss">
.el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }

    .template-img{
      display: inline-block;
      height: 180px;
      position: relative;

      img{
        width: 100%;
        height: 100%;
      }

      span{
        display: inline-block;
        width: 48px;
        height: 48px;
        border-radius: 50%;
        background-color: black;
        opacity: .7;
        text-align: center;
        line-height: 48px;
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        margin: auto;
      }

      .el-icon-caret-right:before{
        font-size: 30px;
        color: #fff;
      }
    }

    .template-title{
      display: inline-block;
      color: #262626;
      font-size: 18px;
      line-height: 24px;
      margin-bottom: 4px;
      margin-top: 10px;
      max-height: 48px;
    }

    .template-detail{
      color: #787878;
      font-size: 13px;
      line-height: 18px;
      max-height: 36px;
    }
}
</style>
