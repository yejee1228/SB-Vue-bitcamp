<template> 
	<div class="login-form">
    <form>
        <h2 class="text-center">조건 검색</h2>
        <div class="form-group">
            <input v-model="searchWord" type="text" class="form-control" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <button @click.prevent="find" type="submit" class="btn btn-primary btn-block">전 송</button>
        </div>
    </form>
	<a @click.prevent="namesOfStudents">학생의 이름</a><br/>       
	<a @click.prevent="streamToArray">스트림을 배열로 전환</a><br/>        
	<a @click.prevent="streamToMap">스트림을 맵으로 전환. 학생이름이  key</a><br/>        
	<a @click.prevent="theNumberOfStudents">학생의 수</a><br/>        
	<a @click.prevent="totalScore">학생들 총점</a><br/>        
	<a @click.prevent="topStudent">1등 학생</a><br/>        
	<a @click.prevent="getStat">전체 학생 성적 통계</a><br/>        
	<a @click.prevent="nameList">전체 학생 이름</a><br/>        
	<a @click.prevent="partitioningByGender">단순분할 (성별로 분할) 남성 true  여성 false</a><br/>        
	<a @click.prevent="partitioningCountPerGender">단순분할 (성별 학생수)</a><br/>        
	<a @click.prevent="partitioningTopPerGender">.단순분할 (성별 1등) 남성 true  여성 false</a><br/>        
	<a @click.prevent="partitioningRejectPerGender">다중분할 (성별 불합격자,  50점이하) 남성 true 여성 false</a><br/>        
	<a @click.prevent="findByBan">단순 그룹화(반별로 그룹화)</a><br/>        
	<a @click.prevent="findByHak">단순 그룹화(학년별로 그룹화)</a><br/>        
	<a @click.prevent="groupByGrade">단순그룹화(성적별로 그룹화)</a><br/>        
	<a @click.prevent="personCountByLevel">단순그룹화 + 통계(성적별 학생수)</a><br/>        
	<a @click.prevent="multiGrouping">다중 그룹화 (학년별, 반별)</a><br/>        
	<a @click.prevent="multiGroupingMax">다중 그룹화 +통계 (학년별, 반별  1등)</a><br/>        
	<a @click.prevent="multiGroupingGrade">다중그룹화 + 통계(학년별, 반별  성적그룹)</a><br/>        
	<!--
	<div>학생 조건 검색결과  
	<table class="table"><tr>
	<th>No.</th><th>아이디</th><th>비번</th><th>이름</th><th>생년월일</th>
	<th>성별</th><th>학년</th><th>반</th><th>점수</th><th>역할</th>
	</tr>
	<tr v-for="(j, i) of list" :key="j.id">
	<td>{{i+1}}</td>
	<td>{{j.userid}}</td>
	<td>{{j.passwd}}</td>
	<td>{{j.name}}</td>
	<td>{{j.birthday}}</td>
	<td>{{j.gender}}</td>
	<td>{{j.hak}}</td>
	<td>{{j.ban}}</td>
	<td>{{j.score}}</td>
	<td>{{j.role}}</td>
	</tr>
	</table>-->
	</div>
	
</template>
<script>
import axios from 'axios'
import {store} from '../../store'
export default{
	data(){
		return {
			context: 'http://localhost:8080/',
			list: [],
			searchWord :'' 
		}
	},
	methods : {
		find(){
			alert(`${this.searchWord} 클릭`)
			axios
			.get(`${this.context}/students/${this.searchWord}`)
			.then(res =>{
				this.list = res.data
				store.state.list = this.list
			})
			.catch(e=>{
				alert('AXIOS FAIL'+e)
			})
		},
		topByGrade(){
			this.searchWord = "topByGrade"
		},
		partitioningByGender(){
			this.searchWord = "partitioningByGender"
		},
		findByHak(){
			this.searchWord = "findByHak"
		},
	}
	
}
</script>
<style scoped>
.table{border : 1px solid black}
.table tr{border : 1px solid black}
.table tr th{border : 1px solid black}
.table tr td{border : 1px solid black}
.login-form {
    width: 340px;
    margin: 50px auto;
}
.login-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.login-form h2 {
    margin: 0 0 15px;
}
.form-control, .btn {
    min-height: 38px;
    border-radius: 2px;
}
.btn {        
    font-size: 15px;
    font-weight: bold;
}
</style>
