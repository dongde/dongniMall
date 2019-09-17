<template>
    <div class="modal-content">

        <header>
            <img class="logo" src="@/assets/img/logo.png" alt="">
        </header>

        <!-- 登录模态框主体 -->
        <!-- <div class="modal-body">
            <div class="modal-msg"></div>
            <input type="text" class="input-area" placeholder="请输入手机号" id="phone" autocomplete="off" value="">
            <input type="password" class="input-area" placeholder="请输入密码" id="password">
            <el-button type="primary" class="submit">登录</el-button>
            <footer>还没有账号？<span class="change-resgister">去注册</span></footer>
        </div> -->

        <!-- 注册模态框主体 -->
        <div class="modal-body">
            <div class="modal-msg"></div>
            <input type="text" class="input-area" placeholder="请输入手机号" id="resgisterPhone">
            <input type="password" class="input-area" placeholder="请输入密码（6-16位）" id="resgisterPassword">
            <div class=" code-box">
                <input type="text" class="input-area" placeholder="请输入验证码" id="verifyCode">
                <a class="code-send" id="codeSend">发送验证码</a>
            </div>
            <el-button type="primary" class="submit">注册</el-button>
            <footer>已有账号？<span class="change-login">去登录</span></footer>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Model'
}
</script>

<style lang="scss" scoped>
.modal-body {
    position: relative;
}

.modal-body .modal-msg {
    position: absolute;
    left: 0;
    right: 0;
    text-align: center;
    top: 0;
    color: red;
}

.modal-content {
    -moz-user-select: none;
    -ms-user-select: none;
    -webkit-user-select: none;
    background: #fff;
    border-radius: 4px;
    box-shadow: 0 5px 15px 0 rgba(0, 0, 0, .15);
    font-size: 16px;
    // margin: 100px auto;
    overflow: hidden;
    text-align: left;
    user-select: none;
    // width: 460px;
}

.modal-body {
    padding: 30px 70px;
}

.modal-content header {
    height: 110px;
    position: relative;
}

.modal-content header .logo {
    margin-left: 198px;
    margin-top: 30px;
    width: 64px;
}

.modal-content .input-area {
    border: none;
    color: #262626;
    font-size: 16px;
    width: 100%;
    border-bottom: 1px solid rgba(0, 0, 0, .08);
    height: 55px;
    line-height: 55px;

    &:focus{
        border: none;
    }
}

.modal-content .forget {
    font-size: 14px;
    padding-top: 10px;
    text-align: right;
    width: 320px;
}

.modal-content .forget a {
    color: #a7a7a7;
}

.modal-content .code-box {
    position: relative;
}

.modal-content .code-send {
    cursor: pointer;
    position: absolute;
    right: 0;
    top: 0;
    color: rgba(66, 133, 244, 1) !important;
    cursor: default;
    font-size: 14px;
    text-align: right;
    width: 80px;
    height: 55px;
    line-height: 55px;
}

.modal-content .submit {
    width: 100%;
    margin-top: 40px;
}

.modal-content footer {
    color: #a7a7a7;
    font-size: 14px;
    padding-bottom: 40px;
    padding-top: 20px;
    text-align: center;
}

.modal-content footer span {
    color: #4285f4;
    cursor: pointer;
}
</style>
