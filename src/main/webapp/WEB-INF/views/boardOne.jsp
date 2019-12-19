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
	<form id="form1" name="form1" method="post"
		style="background-color: inherit; border: 0px">
		<input type="hidden" name="boardNo">

		<table class="board_view">
			<colgroup>
				<col width="15%">
				<col width="*" />
			</colgroup>
			<caption>게시글</caption>
				<tbody>
					<tr>
				
						<th>제목</th>
						<td><a >'${vo.boardTitle}'</a></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><a >${vo.boardContents}</a>
						<td>
					</tr>
				</tbody>
		</table>
		<INPUT type='BUTTON' value='목록으로' onclick='history.back();'>
		<INPUT type='BUTTON' value='삭제' onclick="boardDelete('${vo.boardNo}')">
	</form>
</body>
<script>
	function boardInsert() {
		var form = $('#form1')[0];
		form.action = 'boardInsert';
		form.submit();
	}
	function boardUpdate(boardNo) {
		var form = $('#form1')[0];
		form.action = 'boardUpdate';
		form.boardNo.value = boardNo;
		form.submit();
	}
	function boardDelete(boardNo) {
		var form = $('#form1')[0];
		form.action = 'boardDelete';
		form.boardNo.value = boardNo;
		form.submit();
	}

	</script>
</html>