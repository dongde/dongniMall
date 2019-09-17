<template>
  <div class="common">
    <hr>
  <h1>配方名称:</h1>
  <input type="text" class="pfname">
  <h2>上传配方：</h2>
  </div>
</template>

<script>
export default {
 
}
</script>

<style lang="scss" scoped>
.common{
  padding: 0;
  width: 100%;
  height: 1000px;
  border: 1px solid red;

}
h1{
  margin-top: 50px;
  font-weight: 700;
 
}
h2{
  font-weight: 700;
}
.pfname{
  width: 800px;
  height: 30px;
  border: 1px solid black;
  margin-top: 15px;
  margin-bottom: 15px;
}
</style>
