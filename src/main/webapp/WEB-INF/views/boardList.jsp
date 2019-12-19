<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>


<html>
<head>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border: 1px solid;
}

tr td {
	border: 1px solid;
}

th {
	border: 1px solid;
}
</style>
</head>
<body>
<% request.setCharacterEncoding("utf-8");%>
	<form id="form1" name="form1" method="post"
		style="background-color: inherit; border: 0px">
		<input type="hidden" name="boardNo">
		<table>
			<thead class="thead-light">
				<tr>
					<th style="width: 5%;">글번호</th>
					<th style="width: 50%;">제목</th>
					<th style="width: 10%;">작성자</th>
					<th style="width: 10%;">등록일</th>
					<th style="width: 10%;">수정일</th>
					<th style="width: 10%;">수정</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="boardItem" items="${boardList}">
					<tr>
						<th><c:out value="${boardItem.boardNo}" /></th>
						<td><a style="cursor: pointer;"
							onclick="viewBoard('${boardItem.boardNo}')">${boardItem.boardTitle}</a></td>
						<td><c:out value="${boardItem.userId}" /></td>
						<td><c:out value="${boardItem.registDate}" /></td>
						<td><c:out value="${boardItem.lastDate}" /></td>
						<td><INPUT type='BUTTON' value='수정'	onclick="updateForm('${boardItem.boardNo}')"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<INPUT type='BUTTON' value='추가' onclick="boardWrite()" >
	</form>
</body>
<script>
function viewBoard(boardNo) {
	var form = $('#form1')[0];
	form.action = 'boardOne';
	form.boardNo.value = boardNo;
	form.submit();
}

function updateForm(boardNo) {
	var form = $('#form1')[0];
	form.action = 'updateForm';
	form.boardNo.value = boardNo;
	form.submit();
}

function boardWrite(){
	   location = './insertForm';
	}

</script>
</html>