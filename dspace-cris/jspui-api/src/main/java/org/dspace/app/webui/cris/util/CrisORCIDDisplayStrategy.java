/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * https://github.com/CILEA/dspace-cris/wiki/License
 */
package org.dspace.app.webui.cris.util;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.dspace.app.webui.util.ADiscoveryDisplayStrategy;
import org.dspace.app.webui.util.IDisplayMetadataValueStrategy;
import org.dspace.browse.BrowseItem;
import org.dspace.content.Item;
import org.dspace.content.Metadatum;
import org.dspace.core.ConfigurationManager;
import org.dspace.discovery.IGlobalSearchResult;

public class CrisORCIDDisplayStrategy extends ADiscoveryDisplayStrategy implements IDisplayMetadataValueStrategy
{

    public String getMetadataDisplay(HttpServletRequest hrq, int limit,
            boolean viewFull, String browseType, int colIdx, String field,
            Metadatum[] metadataArray, BrowseItem item,
            boolean disableCrossLinks, boolean emph, PageContext pageContext)
    {
        String metadata = "";
        if (metadataArray.length > 0)
        {
		    String externalContextPath = ConfigurationManager.getProperty("cris","external.domainname.authority.service.orcid");
			metadata += "<a target=\"_blank\" href=\"" + externalContextPath + metadataArray[0].value;
			metadata += "\" class=\"authority\">&nbsp;<img style=\"width: 16px; height: 16px;\" src=\""+ hrq.getContextPath() +"/images/mini-icon-orcid.png\" alt=\"\">";
			metadata += "</a>";

        }
        return metadata;
    }

    public String getMetadataDisplay(HttpServletRequest hrq, int limit,
            boolean viewFull, String browseType, int colIdx, String field,
            Metadatum[] metadataArray, Item item, boolean disableCrossLinks,
            boolean emph, PageContext pageContext)
    {
        // not used
        return null;
    }

    public String getExtraCssDisplay(HttpServletRequest hrq, int limit,
            boolean b, String browseType, int colIdx, String field,
            Metadatum[] metadataArray, Item item, boolean disableCrossLinks,
            boolean emph, PageContext pageContext) throws JspException
    {
        return null;
    }

    @Override
    public String getExtraCssDisplay(HttpServletRequest hrq, int limit,
            boolean b, String browseType, int colIdx, String field,
            Metadatum[] metadataArray, BrowseItem browseItem,
            boolean disableCrossLinks, boolean emph, PageContext pageContext)
            throws JspException
    {
        return null;
    }
    
	@Override
	public String getMetadataDisplay(HttpServletRequest hrq, int limit, boolean viewFull, String browseType,
			int colIdx, String field, List<String> metadataArray, IGlobalSearchResult item, boolean disableCrossLinks,
			boolean emph, PageContext pageContext) throws JspException {
        String metadata = "";
        if (metadataArray.size() > 0)
        {
		    String externalContextPath = ConfigurationManager.getProperty("cris","external.domainname.authority.service.orcid");
			metadata += "<a target=\"_blank\" href=\"" + externalContextPath + metadataArray.get(0);
			metadata += "\" class=\"authority\">&nbsp;<img style=\"width: 16px; height: 16px;\" src=\""+ hrq.getContextPath() +"/images/mini-icon-orcid.png\" alt=\"\">";
			metadata += "</a>";

        }
        return metadata;
	}
}
