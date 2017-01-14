<?xml version="1.0" encoding="UTF-8" ? standalone="yes"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
	<table cellpadding="2" cellspacing="2" border="1">
	<tr>
		<th>nombreaeropuerto</th>
		<th>ciudad</th>
		<th>pais</th>
	</tr> 
	<xsl:apply-templates select="aeropuertos"/>
	</table>
	</xsl:template>
	
	<xsl:template match="aeropuertos">
	<xsl:apply-templates select="aeropuerto"></xsl:apply-templates>
	</xsl:template>
	
	<xsl:template match="aeropuerto">
	<tr>
		
		<td>
		<xsl:value-of select="nombreaeropuerto"></xsl:value-of>
		</td>
		<td>
		<xsl:value-of select="ciudad"></xsl:value-of>
		</td>
		<td>
		<xsl:value-of select="pais"></xsl:value-of>
		</td>
	</tr>
	</xsl:template>
	
	</xsl:stylesheet>