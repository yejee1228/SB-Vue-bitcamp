<template>
	<div class="back">
    <div align = "center">
      <h1>{{loginname}}님의 Mypage</h1>
    </div>
      <div class="sub">
        <div class="pull-left rt size" >
           <fieldset style=" margin-top: 1%; height: 31.5%;border: 2px solid black;">
             <legend><h3>비밀번호 변경</h3></legend>
           <input type="text" v-model="inputpasswd" size="20" placeholder="변경할 비밀번호 입력" style="float: none;width: 70%;">
                <button @click="pwupdate" style="width: 20%; float: right;">수정</button><br/><br/>
           </fieldset>
           <fieldset style="margin-top: 1%; height: 31.5%;border: 2px solid black;">
               <legend><h3>점수 수정</h3></legend>
                <input type="text" v-model="inputscore" size="20" placeholder="수정할 점수 입력" style="float: none;width: 70%;">
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
<script>
import {store} from "../../store"
import axios from "axios"
export default {
	data(){
		return{
			context : 'http://localhost:8080/',
			loginname : store.state.person.name,
			userid: store.state.person.userid,
			passwd: store.state.person.passwd,
			birthday: store.state.person.birthday,
			gender: store.state.person.gender,
			hak: store.state.person.hak,
			ban: store.state.person.ban,
			score: store.state.person.score,
			inputpasswd: '',
			inputscore :'',
			person:{}
		}
	},
	
  methods : {
	pwupdate(){
		alert(`비번수정+${store.state.person.userid}`)
		store.state.person.passwd = this.inputpasswd
		let url =`${this.context}/update`
		let data = {
			person : store.state.person
		}
		let header = {
			'autoorization': 'JWT fefege..',
			'Accept' : 'application/json',
			'Content-Type': 'application/json'
		}
		axios
		.put(url,data,header)
		.then(res=>{
			if(res.data.result === "SUCCESS"){
				alert(`수정성공: ${res.data.person.passwd}`)
			}
			else{
				alert(`수정실패`)
			}
		})
		.catch(()=>{
			alert(`axios 실패 `)
		})
	},
	scoreupdate(){
		alert(`점수수정`)
		store.state.person.score = this.inputscore
		let url =`${this.context}/update`
		let data = {
			person : store.state.person
		}
		let header = {
			'autoorization': 'JWT fefege..',
			'Accept' : 'application/json',
			'Content-Type': 'application/json'
		}
		axios
		.put(url,data,header)
		.then(res=>{
			if(res.data.result === "SUCCESS"){
				alert(`수정성공: ${res.data.person.score}`)
			}
			else{
				alert(`수정실패`)
			}
		})
		.catch(()=>{
			alert(`axios 실패 `)
		})
	}
  }
}
</script>
<style scoped>
.back {width: 800px; margin: 0 auto;}
.sub {width: 70%; height: 600px; margin: 0 auto; text-align: center;}
.pull-left {float: left;}
.pull-right {float: right;}
.top {margin-top: 1%;}
.rt {margin-right: 1%;}
.size {width: 49.5%; height: 100%;}
</style>