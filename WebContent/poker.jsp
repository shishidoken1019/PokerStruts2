<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Poker</title>
<style type="text/css">
li {
	margin-left:0px;
	list-style-type: none;
}
</style>
</head>
<body>
	<h1>ポーカー</h1>
	<h2>親の手札</h2>
	<ul>
		<s:iterator value="parent_card" status="rowstatus">
				<s:if test="result.length() != 0">
					<li><s:property value="parent_card.get(#rowstatus.index)" /></li>
				</s:if>
				<s:else>
					<li>■</li>
				</s:else>
		</s:iterator>
	</ul>

	<h2>自分の手札</h2>
	<ul>
		<s:iterator value="player_card" status="rowstatus">
			<li><s:property value="player_card.get(#rowstatus.index)" /></li>
		</s:iterator>
	</ul>
	<s:form name="form1">
		<s:if test="result.length() == 0">
			<p>
				<s:submit method="hit" value="ヒット" />
			</p>
			<p>
				<s:submit method="stand" value="スタンド" />
			</p>
		</s:if>
	</s:form>

	<s:if test="result.length() != 0">
		<h4>
			<font color="red"><s:property value="result" /></font>
		</h4>
		<p>
			あなたのカード役 :
			<s:property value="player_card_skill" />
		</p>
		<p>
			親のカード役 :
			<s:property value="parent_card_skill" />
		</p>
		<p>
			<a href=./blackJack.action>継続してポーカーを遊ぶ</a>
		</p>
		<p>
			<a href=./index.action>ゲームを変更する</a>
		</p>
	</s:if>
</body>
</html>