 <table>
	<tr>
		<th>标题</th>
		<th>内容</th>
	</tr>
<#list newsList.data as tmp>
	<tr><td>${tmp.nTitle}</td><td>${tmp.nContent}</td></tr>
</#list>
</table>