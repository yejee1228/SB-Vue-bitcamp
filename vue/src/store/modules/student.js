import Constant from '@/store/modules/mutation_types'
import axios from 'axios'
import router from '@/router'
import api from '@/api'

const state = {
	person : {},
	sidebar : 'studentSidebar',
}
const getters = {
	getPerson : state => state.person,
	getSidebar : state => state.sidebar
}
const actions = {
	async student_login({commit, state}){
		alert(`${this.userid} ,  ${this.passwd}`)
		api.login(state.userid, state.passwd)
		.then(data => commit('login', data.data))
		.then(()=>{router.push({name: 'home'})})
		alert(`아이디 : ${this.userid} , 비밀번호 : ${this.passwd}`)
		let url = `${this.context}/login`
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
		.post(url, data, header)
		.then(res=>{
		if(res.data.result === "SUCCESS"){
			alert(`로그인 성공 : ${this.userid}`)
			this.$store.commit (Constant.PERSON, res.data.person)
			this.$store.commit (Constant.LOGINSTATE, true)
			this.$store.state.authCheck = false
			alert(`스토어에 저장 성공 ${this.$store.state.person.name}`)
			if(this.$store.state.person.role !== 'student'){
			this.$store.commit (Constant.SIDEBAR, 'adminSidebar')
			this.$store.commit (Constant.HEADERMESSAGE, '관리자 화면')
			this.$router.push({path: '/admin'})
		}else{
			this.$store.commit (Constant.SIDEBAR, 'studentSidebar')
			this.$store.commit (Constant.HEADERMESSAGE, '학생 화면')
			this.$router.push({path: '/myPage'})
			}
		}else{
			alert(`로그인 실패 `)
			this.$router.push({path:'/login'})
		}
		})
		.catch(()=>{
		alert('AXIOS 실패')
		})
	},
	async join(){
			let url = `${this.context}/join`
			let data = {
				userid : this.userid,
				passwd : this.passwd,
				name : this.name,
			}
			let headers = {
					'authorization': 'JWT fefege..',
					'Accept' : 'application/json',
					'Content-Type': 'application/json'
			}
			axios
			.post(url, data, headers)
			.then(res=>{
				if(res.data.result==="SUCCESS"){
					this.$store.state.userid = res.data.person.userid
					this.$store.state.passwd = res.data.person.passwd
					this.$store.state.name = res.data.person.name
					this.$store.state.id = res.data.person.id
					this.$router.push({path : '/mypage'})
				}else{
					this.$router.push({path : '/join'})
				}
			})
			.catch(()=>{
				alert(`axios 실패!`)
			})
		}
}
const mutations = {
	LOGIN (state, person) {
		state.person = person
	},
	LOGOUT (state) {
		state.person = null
	}

}

export default {
	name : 'student',
	namespaced : true, // 재활용할 수 있다.
	state,
	getters,
	actions,
	mutations
}