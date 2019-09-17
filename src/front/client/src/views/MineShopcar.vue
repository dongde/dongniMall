<template>
    <div class="minemessage">
        <div class="title">
             <h1>我的川料</h1>
         </div>
         <template>
  <el-table
  class="mintable"
    :data="tableData"
    style="width: 100%">
    <el-table-column
      label="商品"
      width="180">
      <template slot-scope="scope">
        <span >{{ scope.row.date }}</span>
      </template>
    </el-table-column>
     <el-table-column
      label="描述"
      width="180">
      <template slot-scope="scope">
        <span>{{ scope.row.describe }}</span>
      </template>
    </el-table-column>
     <el-table-column
      label="数量"
      width="180">
      <template slot-scope="scope">
        <span >{{ scope.row.price }}</span>
      </template>
    </el-table-column>
     <el-table-column
      label="单价"
      width="180">
      <template slot-scope="scope">
        <span >{{ scope.row.count }}</span>
      </template>
    </el-table-column>
     <el-table-column
      label="小计"
      width="180">
      <template slot-scope="scope">
        <span >{{ scope.row.amount }}</span>
      </template>
    </el-table-column>
   
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>
    </div>
</template>
<script>
export default {
       data() {
      return {
        tableData: [{
          date: '商品图片',
          describe:'商品描述',
          price: '18',
          count:'1',
          amount:'18'
        }, ]
      }
    },
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      }
    }
}
</script>
<style lang="scss" scoped>
.head{
    text-align: center;
}
.minemessage{
    width: 100%;
    height: 800px;
    // margin-top: 60px;
    /* border: 1px solid red; */
}
.title{
    width: 100%;
    text-align: center;
    font-weight: 700
    
}
h1{
    font-size: 40px;
}
.mintable{
    margin-top: 50px;
    margin-left: 80px;
}

</style>