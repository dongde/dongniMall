<template>
  <div id="app">
    <header>
      <AppHeader />
    </header>
    <div class="main content">
      <router-view name="aside"></router-view>
      <keep-alive>
        <router-view></router-view>
      </keep-alive>
    </div>
    <footer>
      <router-view name="footer"></router-view>
    </footer>
  </div>
</template>

<script>
import AppHeader from '@/components/AppHeader'

export default {
  name: 'App',
  components: {
    AppHeader
  }
}
</script>

<style lang="scss">
 html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed,
figure, figcaption, footer, header, hgroup,
menu, nav, output, ruby, section, summary,
time, mark, audio, video, input,button {
  margin: 0;
  padding: 0;
  border: 0;
  font-size: 100%;
  font: inherit;
  vertical-align: baseline;
}
article, aside, details, figcaption, figure,
footer, header, hgroup, menu, nav, section {
  display: block;
}
body {
  line-height: 1;
}
ol, ul {
  list-style: none;
}
blockquote, q {
  quotes: none;
}
blockquote:before, blockquote:after,
q:before, q:after {
  content: '';
  content: none;
}
table {
  border-collapse: collapse;
  border-spacing: 0;
}
a{
  text-decoration: none;
}
img{
  vertical-align: middle;
}
.content{
  margin: 0 auto;
  width: 1180px;
}
.common{
  width: 1030px;
  padding-top: 20px;
}
.color1{
  color: #bf0000;
}
.bg-color1{
  background-color: #bf0000;
  color: #fff;
}
.tc{
  text-align: center;
}
.mb{
    margin-bottom: 20px;
  }
.el-dialog__body{
  padding: 0;
}
.el-dialog__headerbtn .el-dialog__close{
  font-size: 20px;
}
.el-dialog__header{
  margin-bottom: 10px;
}
.el-input.is-active .el-input__inner, .el-input__inner:focus{
  border: none;
}
.main{
  display: flex;
} 
</style>
