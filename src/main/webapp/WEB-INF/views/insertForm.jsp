<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>

<meta charset="EUC-KR">
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
	<form id="form1" name="form1" method="post"
		style="background-color: inherit; border: 0px">
		<input type="hidden" name="boardNo">

		<c:if test="${ vo.boardNo != null }">
			<table class="board_view">
				<colgroup>
					<col width="15%">
					<col width="*" />
				</colgroup>
				<caption>게시글</caption>
				<tbody>
					<th>제목</th>
					<td><textarea name="boardTitle">${vo.boardTitle}</textarea></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea rows="20" cols="30" name="boardContents">${vo.boardTitle}</textarea>
						<td>
					</tr>
				</tbody>
			</table>

			<INPUT type='BUTTON' value='목록으로' onclick='history.back();'>
			<INPUT type='BUTTON' value='수정' onclick="boardWrite('${vo.boardNo}')">
		</c:if>

		<c:if test="${ vo.boardNo == null }">
			<table>
				<tbody>
					<tr>
						<th>제목</th>
						<td><textarea name="boardTitle"></textarea></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea rows="20" cols="30" name="boardContents"></textarea>
						<td>
					</tr>
				</tbody>
			</table>

			<INPUT type='BUTTON' value='목록으로' onclick='history.back();'>
			<INPUT type='BUTTON' value='추가' onclick="boardWrite('${vo.boardNo}')">
		</c:if>
	</form>
</body>
<script>
	function boardWrite(boardNo){
		   var form = $('#form1')[0];
		   form.action = 'boardWrite';
		   form.boardNo.value = boardNo;
		   form.submit();
		}	
</script>
</html>