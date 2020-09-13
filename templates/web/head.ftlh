<head>
<meta charset="${meta.charset}"/>
	<title>${title}</title>
<#foreach style in head.styles>
<link rel="stylesheet" href="${style}"/>
</#foreach>
<#foreach script in head.scripts>
<script src="${script}"></script>
</#foreach>
</head>