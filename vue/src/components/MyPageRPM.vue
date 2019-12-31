<template>
<div class="carPage">
	<div class="carInfo">
		<div class="img"><h5>차 사진</h5></div>
		<div class="carInfoBox">
			<div class="carInfoText" >
			<h3>000 님의 차량정보</h3> <br/>
			<h4>모델명: 벤쯔</h4> <br/>
			<h4>연식: 2020년 1월</h4> <br/>
			<h4>마지막 정비일 : 2020년 1월 5일</h4> <br/>
			</div>
			<button class="gasStation">주유소찾기</button>
			<button class="maintenance">정비소찾기</button>
		</div>
	</div>
	<div style="height:70px"></div>
	<div class="carNotice">
		<div>
		<h2>정비 주기 알림</h2>
		</div>
		<div style="height:30px"></div>
		<div class="noticeBox">
			<div id="oil"><b>엔진오일교체</b><br/><br/>
			000일마다 교체<br/>
			000일 남았어요. <br/>
			</div>
			<div id="tire"><b>타이어교체</b><br/><br/>
			000일마다 교체<br/>
			000일 남았어요. <br/>
			</div>
			<div id="battery"><b>배터리교체</b><br/><br/>
			000일마다 교체<br/>
			000일 남았어요. <br/>
			</div>
			<div id="check"><b>점검알림</b><br/><br/>
			000일마다 교체<br/>
			000일 남았어요. <br/>
			</div>
		</div>
	</div>
</div>
</template>
<script></script>
<style scoped>
.carInfoBox{
    float: right;
}
.carInfoText{
	height: 350px;
	width: 350px;
}
.carPage{
	width: 900px;
	margin: auto;
}
.carInfo{
	height: 400px;
}
.img{
	width: 300px;
    height: 400px;
    float: left;
	border: 1px solid black;
}
button{
	float: right;
	padding: 20px;
}
.noticeBox{
	display : grid;
	grid-template-columns : 25% 25% 25% 25%;
	height: 150px;
    text-align: center;
    font-size: 20px;
}
.noticeBox div{
	margin-top: 20px;
}
</style>