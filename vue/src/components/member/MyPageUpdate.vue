<template>
<div id="app">
	<layout>
		<template #header="header">
			<h1>{{header.title}}</h1>
			<div class="headerdiv">
				<router-link  @click="logout">로그아웃</router-link><br/>
				<router-link @click.prevent="withdrawl">회원탈퇴</router-link>
			</div>
		</template>
		<template #sidebar="sidebar">
			<ul class="menu">
				<li v-for="i of sidebars" :key="i.menu">
					<router-link :to="i.link">{{i.menu}}</router-link>
				</li>
			</ul>
		</template>
		<template #content="content">
				<div class="back">
    <div align = "center">
      <h1>{{loginname}}님의 Mypage</h1>
        <h3</h3>
    </div>
      <div class="sub">
        <div class="pull-left rt size" >
           <fieldset style=" margin-top: 1%; height: 31.5%;border: 2px solid black;">
             <legend><h3>비밀번호 변경</h3></legend>
           <input type="text" v-model="passwd" size="20" placeholder="변경할 비밀번호 입력" style="float: none;width: 70%;">
                <button @click="pwupdate" style="width: 20%; float: right;">수정</button><br/><br/>
           </fieldset>
           <fieldset style="margin-top: 1%; height: 31.5%;border: 2px solid black;">
               <legend><h3>점수 수정</h3></legend>
                <input type="text" v-model="score" size="20" placeholder="수정할 점수 입력" style="float: none;width: 70%;">
                <button @click="scoreupdate" style="width: 20%; float: right;">수정</button><br/><br/>
           </fieldset>
        </div>
        <div class="pull-right size" >
            <fieldset style="height: 49%;border: 2px solid black;">
                <legend><h3>정보보기</h3></legend>
        이름: {{loginname}}<br/>
                아이디: {{userid}}<br/>
                비밀번호: {{passwd}}<br/>
                생일: {{birthday}}<br/>
                성별: {{gender}}<br/>
                학년: {{hak}}<br/>
                반: {{ban}}<br/>
                평균점수: {{score}}<br/>
            </fieldset>
        </div>
      </div>
    </div>
		</template>
		<template #footer="footer">
			{{footer.footerText}}
		</template>
	</layout>
</div>
</template>
<script>
import {store} from "../../store"
import axios from "axios"
export default {
	data(){
		return{
			loginname : store.state.name,
			context : 'http://localhost:8080/',
			userid: store.state.loginedUId,
			passwd: store.state.loginedPwd,
			birthday: store.state.birthday,
			gender: store.state.gender,
			hak: store.state.hak,
			ban: store.state.ban,
			score: store.state.score
		}
	},
	create(){
  },
  methods : {
    logout(){
      alert(`로그아웃`)
      store.state.loginedUId = ''
      store.state.loginedPwd = ''
      store.state.id = ''
      store.state.name = ''
      store.state.birthday = ''
      this.$router.push({path:'/login'})
	},
	withdrawl(){
		alert(store.state.loginedUId)
		let url = `${this.context}/withdrawl/${store.state.loginedUId}`
		axios.delete(url)
		.then(
			alert(`회원탈퇴`)
		)
		.catch(()=>{
			alert(`회원탈퇴 실패`)
		})
	},
	pwupdate(){
		alert(`비번수정`)
		let url =`${this.context}/updatepasswd`
		let data = {
			userid: this.userid,
			passwd: this.passwd
		}
		let header = {
			'autoorization': 'JWT fefege..',
        'Accept' : 'application/json',
        'Content-Type': 'application/json'
		}
		axios
		.post(url,data,header)
		.then(res=>{
			store.state.loginedPwd = res.data.passwd
		})
		.catch(
			alert(`비번수정 실패 `)
		)
	},
	scoreupdate(){
		alert(`점수수정`)
		let url =`${this.context}/updatescore`
		let data = {
			userid: this.userid,
			score: this.score
		}
		let header = {
			'autoorization': 'JWT fefege..',
        'Accept' : 'application/json',
        'Content-Type': 'application/json'
		}
		axios
		.post(url,data,header)
		.then(res=>{
			store.state.score=res.data.score
		})
		.catch()
	}
  }
}
</script>
<style scoped>
.back {width: 1100px; margin: 0 auto;}
.sub {width: 70%; height: 600px; margin: 0 auto; text-align: center;}
.pull-left {float: left;}
.pull-right {float: right;}
.top {margin-top: 1%;}
.rt {margin-right: 1%;}
.size {width: 49.5%; height: 100%;}
</style>