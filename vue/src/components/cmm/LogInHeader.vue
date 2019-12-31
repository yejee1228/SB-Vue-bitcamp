<template>
<div id="auth-box">	
     <a @click.prevent="logout"><h6>로그아웃</h6></a>
     <a @click="withdrawl"><h6>회원탈퇴</h6></a>
</div>
</template>
<script>
import axios from 'axios'
export default {
	data(){
		return {
			context : 'http://localhost:8080/'
		}
	},
	methods:{
		logout(){
      alert(`로그아웃`)
		this.$store.state.person={}
		this.$store.state.authCheck=false
      this.$router.push({path:'/login'})
	},
		withdrawl(){
			alert(this.$store.state.person.userid)
			let url = `${this.context}/withdrawl/${this.$store.state.person.userid}`
			axios.delete(url)
			.then(()=>{
				alert(`회원탈퇴`)
			})
			.catch(()=>{
				alert(`회원탈퇴 실패`)
			})
			this.$router.push({path: '/login'})
		},
	}
}
</script>