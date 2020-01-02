import Constant from '@/store/modules/mutation_types'
import axios from 'axios'

const state = {
	admin : {},
    list : {},
    loginstate : false,
	sidebar : 'preSidebar',
	headerMessage : '공통화면',
}
const getters = {
	getList : state => state.list,
    getAdmin : state => state.admin,
    getLoginstate : state => state.loginstate,
	getSidebar : state => state.sidebar,
	getHeaderMessage : state => state.headerMessage,
}
const actions = {
	login({commit},{context, userid, passwd}){
            alert(`${context},${userid},${passwd}` )
            
            let url = `${context}login`
            let headers = {
                'authorization': 'JWT fefege..',
                'Accept' : 'application/json',
                'Content-Type': 'application/json'
            }
            axios
            .post(url, {userid, passwd}, headers)
            .then(({data})=>{commit('LOGIN',data)})
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
                  birthday : this.birthday
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
                      this.$store.commit(Constant.PERSON, res.data.person)
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
	LOGIN (state, data) {
        alert(`>>> ${data.result}`)
        state.loginstate = true
        state.headerMessage = '관리자페이지'
        state.admin = data.person
    },
    LOGOUT (state) {
        state.person = null
    },
}

export default {
  name: 'admin',
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}