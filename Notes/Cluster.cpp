#include "stdafx.h"
#include "cluster.h"
#include "stats.h"
#include"srs.h"
#include "ClusterInputDialog.h"
#include "RightSize.h"
//#include "GraphSurveyDialog.h"
//#include "VaryClusterDialog.h"
#include "ShowGraphDialog.h"
#include "VaryAssumptionsDialog.h"

IMPLEMENT_DYNAMIC(CCluster, CCalc)


CCluster::CCluster()
{
	
	// initialize variables
	m_nb = 20;
	m_csroh = "";
	m_droh	= 0;
	m_nConfidenceInterval = 5;
	m_nConfidenceLevel = 95;
	m_dDesignEffect = 0;
	m_nClusters = 0;
	m_nn= 0;
	m_csrohChoice = "";
	m_bResultsReady = FALSE;
	m_nUserAssumptionsRadioChoice = PROPORTION;
	
	// set default roh choice
	m_csroh = "Demographic Variables: 0.02";
    //#ifdef _DEBUG
    //	TRACE("\nMade in Shiprock:\n");
    //	Dump(afxDump);
    // #endif
    
}

void CCluster::InitializeListBoxes(void)
{
	// Initialize listboxes if this cluster will be calling for user input.
	// Otherwise, don't waste effort as the object will only be used to calculate
	// and won't need to ask for user input
	
    if(m_rohList.IsEmpty())
    {
        m_rohList.AddTail("Prevalence of an Infectious Disease: 0.3");
        m_rohList.AddTail("Prevalence of Illness in General: 0.02");
        m_rohList.AddTail("Low Utilization of Health Cares Services: 0.1");
        m_rohList.AddTail("High Utilization of Health Cares Services: 0.3");
        //	m_rohList.AddTail("");
        m_rohList.AddTail("Demographic Variables: 0.02");
    }
    
    //m_clusterList.AddTail( "Budsy gobbles");
    if (m_clusterList.IsEmpty())
    {
        m_clusterList.AddTail( "Estimated Prevalence");
        m_clusterList.AddTail( "Cluster Size" );
        m_clusterList.AddTail( "Confidence Interval" );
        m_clusterList.AddTail( "Confidence Coeffecient" );
        m_clusterList.AddTail( "ROH" );
    }
	
}

#ifdef _DEBUG
void CCluster::Dump(CDumpContext& dc) const
{
	
 	dc 	<< "\nDumping a CCluster of size " << sizeof (this) << "\n"
    << "m_nConfidenceInterval:  " << m_nConfidenceInterval << "\n"
    << "m_nb:  " << m_nb << "\n"
    << "m_csroh:  " << m_csroh << "\n"
    << "m_nClusters:  " << m_nClusters << "\n"
    << "m_csrohChoice:  " << m_csrohChoice << "\n"
    << "Now dumping the CCalc part...\n";
	CCalc::Dump(dc);
}
#endif


bool CCluster::Calculate(void)
{
    //	char szmess[80];
    //	sprintf(szmess, "m_bInputDataReady is %d.", m_bInputDataReady);
    //	AfxMessageBox(szmess);
    //	if (m_bInputDataReady)
    //	{
    double dPrevalence = (double)m_nProportion / 100;  // convert from percents
    
    // CI = SE * dz_alpha, so SE = CI / dz_alpha
    // convert integer Confidence Coeffecient to floating proportion
    double dalpha = (100 - (double)m_nConfidenceLevel)/ 100;
    // get two sided z value
    // double dz_alpha = invprob ( dalpha / 2 ); // divide by 2 for 2 sided  z
    SetZValue(dalpha);	// get two sided z value
    // calculate standard error
    double dStandardError = ((double)m_nConfidenceInterval/ 100) / m_dz;
    //DEBUGGER
	//	dStandardError = 0.025;
    // and roh
    //double  droh = atof( m_csroh );
    double dClusters = 0;
    
    m_dDesignEffect = (double)(1 + (m_nb - 1) * m_droh);
    
    dClusters = ( dPrevalence * (1 - dPrevalence) * m_dDesignEffect ) \
    / ( dStandardError * dStandardError  * (double)m_nb );
    
    // round up if there is a fractional part to fClusters
    
    m_nClusters = RoundUp(dClusters);
    
    m_nn= m_nClusters * m_nb;
    
    // set the integer prevalence member
    m_nProportion = Round(dPrevalence * 100); // change to percent
    return m_bResultsReady = TRUE;  // ready to display results
    
    //	}
    //	else
    //		return m_bResultsReady = FALSE;
    
	
}


// Note that I did not make a copy constructor for each type of CCalc because
// I usually handle them with generic pointers.  It is easier to isolate the testing
// of type to the constructor than scatter it around the code.
CCluster::CCluster( const CCalc& source )
{
    
    //first copy the ccalc part
    
    //first copy the ccalcpart
    //	m_lTargetPop = source.m_lTargetPop;			// holds target population size
    //	m_nConfidenceInterval = source.m_nConfidenceInterval;;	// holds width of confidence interval
    //	m_nConfidenceLevel = source.m_nConfidenceLevel;		// holds Confidence Coeffecient as integer
    //	m_nProportion = source.m_nProportion; 			// holds prevalence
    //	m_nn = source.m_nn;               	// holds final sample size
    
	//mark as not finished even though the source was
    //	m_bResultsReady= FALSE;
    
    
	//first copy the ccalc part
	CCalc* pdest = (CCalc*)this;
	CCalc* psource = (CCalc*)&source;
	
	*pdest = *psource;
    
	if (source.IsKindOf(RUNTIME_CLASS(CCluster)))
	{
		// initialize variables
		CCluster*	pcluster = (CCluster*)&source;  // Make a cluster pointer now that
        //we know it is safe
		m_nb = pcluster->m_nb;
		m_csroh = pcluster->m_csroh;
		//m_nConfidenceInterval = pcluster->m_nConfidenceInterval;
		//m_nConfidenceLevel = pcluster->m_nConfidenceLevel;
		m_dDesignEffect = pcluster->m_dDesignEffect;
		m_nClusters = pcluster->m_nClusters;
		//m_nn= pcluster->m_nn;
		m_droh =	pcluster->m_droh;
		//m_nProportion = pcluster->m_nProportion;
		m_csrohChoice = pcluster->m_csrohChoice;
		POSITION pos = NULL;
		
		// initialize listboxes by COPYING THEM to capture any user changes
		for( pos = pcluster->m_rohList.GetHeadPosition(); pos != NULL; )
	     	m_rohList.AddTail(pcluster->m_rohList.GetNext(pos));
		
		
		for( pos = pcluster->m_clusterList.GetHeadPosition(); pos != NULL; )
	     	m_clusterList.AddTail(pcluster->m_clusterList.GetNext(pos));
		
		//cluster list is always the same so no need to copy
		
		// set default roh choice
		m_csroh = pcluster->m_csroh;
		
		//TRACE("\nA CCluster made in heaven by the copy constructor.\n");
		//Dump(afxDump);
	}
	else if (source.IsKindOf(RUNTIME_CLASS(CSRS)))
	{
		m_droh = 0;
		m_csroh ="0";
		m_dDesignEffect = 1;
		m_nb= 1;
		m_nClusters = 0;
        
        
	}
	else
	{
		TRACE("CCluster::CCluster( const CCalc& source ): Can't copy source because it is neither CCluster or CSRS object");
		TRACE("It is at %p.", &source);
		AfxAbort();
	}
}



// Define assignment operator.
CCluster& CCluster::operator=( CCluster& rRightCluster )
{
    // initialize variables
	m_nb = rRightCluster.m_nb;
	m_csroh = rRightCluster.m_csroh;
	m_nConfidenceInterval = rRightCluster.m_nConfidenceInterval;
	m_nConfidenceLevel = rRightCluster.m_nConfidenceLevel;
	m_dDesignEffect = rRightCluster.m_dDesignEffect;
	m_nClusters = rRightCluster.m_nClusters;
	m_nn= rRightCluster.m_nn;
	m_droh	= rRightCluster.m_droh;
	m_nProportion = rRightCluster.m_nProportion;
	m_csrohChoice = rRightCluster.m_csrohChoice;
	m_bResultsReady = FALSE;
	
	POSITION pos = NULL;
	
	m_rohList.RemoveAll();
	// initialize listboxes by COPYING THEM to capture any user changes
	for( pos = rRightCluster.m_rohList.GetHeadPosition(); pos != NULL; )
     	m_rohList.AddTail(rRightCluster.m_rohList.GetNext(pos));
	
	m_clusterList.RemoveAll();
	for( pos = rRightCluster.m_clusterList.GetHeadPosition(); pos != NULL; )
     	m_clusterList.AddTail(rRightCluster.m_clusterList.GetNext(pos));
	
	//cluster list is always the same so no need to copy
	
	// set default roh choice
	m_csroh = rRightCluster.m_csroh;
	
    return *this;  // Assignment operator returns left side.
}

void CCluster::Show( CDC* pDC )
{
    
	
	
	// Now print data
	TEXTMETRIC tm;
	pDC->GetTextMetrics( &tm );
	short cxChar = (short) tm.tmAveCharWidth;
	short cyChar = (short) tm.tmHeight + (short)tm.tmExternalLeading;
	
	const ctabChars = 25;
	const cfieldChars = 6;
	const ctabWidth = ctabChars * cxChar;
	char s[100];
	CString cs;
	// assign current position
	CPoint currPos = pDC->GetCurrentPosition();
    
	pDC->SetTextAlign(TA_LEFT | TA_TOP );
    
	cs = "Cluster Sample:";
	pDC->TextOut( currPos.x, currPos.y, cs );
	
    currPos.y += cyChar;	// move 1 line
	pDC->SetTextAlign(TA_LEFT | TA_TOP );
    
    
	cs = "Clusters Needed:";
	pDC->TextOut( currPos.x, currPos.y, cs );
    sprintf(s, "%10d", (int)(m_nClusters ) );
    pDC->TextOut( currPos.x + ctabWidth, currPos.y, s, strlen( s ) );
	
    currPos.y += cyChar;	// move to next line
	pDC->SetTextAlign(TA_LEFT | TA_TOP );
    
    
	cs = "Total Responses Needed:";
	pDC->TextOut( currPos.x, currPos.y, cs );
    sprintf(s, "%10d", m_nn);
    pDC->TextOut( currPos.x + ctabWidth, currPos.y, s, strlen( s ) );
	
    
	currPos.y += cyChar;	// move to next line
	pDC->SetTextAlign(TA_LEFT | TA_TOP );
    
	sprintf(s, "Cluster Size:");
	pDC->TextOut( currPos.x, currPos.y, s, strlen( s ) );
    
    sprintf(s, "%10d", m_nb );
    pDC->TextOut( currPos.x + ctabWidth, currPos.y, s, strlen( s ) );
    
    currPos.y += cyChar;	// move to next line
	pDC->SetTextAlign(TA_LEFT | TA_TOP );
    
    
	sprintf(s, "Estimated Prevalence:");
	pDC->TextOut( currPos.x, currPos.y, s, strlen( s ) );
    
    
    sprintf(s, "%10d%%", m_nProportion );
    pDC->TextOut( currPos.x + ctabWidth, currPos.y, s, strlen( s ) );
    
    currPos.y += cyChar;	// move to next line
	pDC->SetTextAlign(TA_LEFT | TA_TOP );
	
    
	sprintf(s, "Confidence Coeffecient:");
	pDC->TextOut( currPos.x, currPos.y, s, strlen( s ) );
    
    sprintf(s, "%10d%%", m_nConfidenceLevel );
    pDC->TextOut( currPos.x + ctabWidth, currPos.y, s, strlen( s ) );
    
    currPos.y += cyChar;	// move to next line
	pDC->SetTextAlign(TA_LEFT | TA_TOP );
	
	sprintf(s, "Confidence Interval:");
	pDC->TextOut( currPos.x, currPos.y, s, strlen( s ) );
    
    sprintf(s, "%9d%%", m_nConfidenceInterval);
    s[0] = 177; // add a plus/minus
    pDC->TextOut( currPos.x + ctabWidth, currPos.y, s, strlen( s ) );
    
    currPos.y += cyChar;	// move to next line
	pDC->SetTextAlign(TA_LEFT | TA_TOP );
	
	sprintf(s, "Rate of Homogeneity:");
	pDC->TextOut( currPos.x, currPos.y, s, strlen( s ) );
    
    sprintf(s, "%10s", m_csroh );
    pDC->TextOut( currPos.x + ctabWidth, currPos.y, s, strlen( s ) );
    
	currPos.y += cyChar;	// move to next line
	pDC->SetTextAlign(TA_LEFT | TA_TOP );
	
	sprintf(s, "Design Effect:");
	pDC->TextOut( currPos.x, currPos.y, s, strlen( s ) );
    
    sprintf(s, "%10.2f", m_dDesignEffect );
    pDC->TextOut( currPos.x + ctabWidth, currPos.y, s, strlen( s ) );
    
    // if user entered z value, print it so they are reminded
	if (((CRightSizeApp*)AfxGetApp())->m_dUserZValue)  //user set a z value
	{
		currPos.y += cyChar;	// move to next line
		pDC->SetTextAlign(TA_LEFT | TA_TOP );
		
		sprintf(s, "User supplied z value:");
		pDC->TextOut( currPos.x, currPos.y, s, strlen( s ) );
        
		sprintf(s, "%10.4f", (float)m_dz );
		pDC->TextOut( currPos.x + ctabWidth, currPos.y, s, strlen( s ) );
	}
    
	
    
}

bool CCluster::GetInputData(void)
{
	// initialize member variable of this cluster
	// so we can load it into the dialog
    
	InitializeListBoxes();
	
	CClusterInputDialog dlg;
    // set dialog box var defaults
    
	dlg.m_prohList = &m_rohList;
	dlg.m_lTargetPop = m_lTargetPop; // This value is never used for calculations, only graphs
	dlg.m_nProportion = m_nProportion;
	dlg.m_nb = m_nb;
	dlg.m_csroh = m_csroh;	// holds number as string
	dlg.m_csroh = m_csrohChoice; // holds text string which may be more than number for combo box
	dlg.m_nConfidenceInterval = m_nConfidenceInterval;
	dlg.m_nConfidenceLevel = m_nConfidenceLevel;
    //	dlg.m_droh	= m_droh;
    
    
	if ( dlg.DoModal() == IDOK )
	{
		m_lTargetPop = dlg.m_lTargetPop;
		m_nProportion = dlg.m_nProportion;
		m_nb = dlg.m_nb;
		m_csroh = dlg.m_csroh;
		m_droh = atof((const char*)dlg.m_csroh);
		m_nConfidenceInterval = dlg.m_nConfidenceInterval;
		m_nConfidenceLevel = dlg.m_nConfidenceLevel;
		// the user did not use a default choice, they entered a number
		if (dlg.m_csrohChoice == dlg.m_csroh)
			m_csrohChoice = dlg.m_csroh;
		else
			m_csrohChoice = dlg.m_csrohChoice;
		
		
		if (m_rohList.Find(m_csrohChoice) == NULL  && m_csrohChoice != "")
			m_rohList.AddTail(m_csrohChoice);
        
	    
		return TRUE;
	}
	else
		return FALSE;	// dlg returned ID_CANCEL
	
}


int CCluster::Graph(CShowGraphDialog &dlg)
{
	// First we need to find what assumption the user wants to vary.
	int nAssumption = GetUserAssumptionToVary();
	if (nAssumption == USER_CANCELLED)
		return USER_CANCELLED;  // don't draw a graph
	// Now we need to calculate an array of sample sizes
	// using different values based on reasonable variations
	// of the user's choices
	
	// arrays to hold the sample sizes as integers or doubles
	int* pnarray = new int[POINTS_TO_GRAPH];
	double* pdarray = new double[POINTS_TO_GRAPH];
	long* plarray = new long[POINTS_TO_GRAPH];
	// The Y axis will always hold the same text:
	sprintf(dlg.m_szLeftTitle, "Clusters");
    
	// We need an array of CCluster objects to hold the information
	// create an array of calcs to get points to graph
	CCluster* pCalcArray = new CCluster[POINTS_TO_GRAPH];
	// make cluster objects identical to this one
    for (int i = 0; i < POINTS_TO_GRAPH; i++)
        pCalcArray[i] = *this;
	
	switch(nAssumption)
	{
            
		case TARGET_POPULATION:
		{
            
			// Create the title
			sprintf(dlg.m_szGraphTitle, "Cluster Survey: Proportion: %d, %d%% CI %c%d%%, Cluster Size %d, ROH %s ",
                    m_nProportion,  m_nConfidenceLevel, 177, m_nConfidenceInterval, m_nb, m_csroh);
			sprintf(dlg.m_szBottomTitle, "Target Population");
            
			VaryAboutMultiply((long) 100, m_lTargetPop, MAX_POP, 10, plarray, POINTS_TO_GRAPH);
            // Now calculate the sample sizes
            
            for(int i = 0; i < POINTS_TO_GRAPH; i++)
            {
                //pCalcArray[i].m_lTargetPop = plarray[i];
                //pCalcArray[i].Calculate();
				//	dlg.m_ndataArray[i] = m_nn;
                dlg.m_pfGraphDataArray[0][i] = (float)pCalcArray[i].m_nn;
                dlg.SetBigXAxisNumbers(plarray[i], i);
                
            }
            
			break;
		} // TARGET_POPULATION
		case PROPORTION:
		{
			// Create the title
			sprintf(dlg.m_szGraphTitle, "Cluster Survey:  CC %d%% CI %c%d%%, Cluster Size %d, ROH %s ",
                    m_nConfidenceLevel, 177, m_nConfidenceInterval,  m_nb, m_csroh);
			sprintf(dlg.m_szBottomTitle, "Proportion");
            
			// Choose arbitrary factor of 10 to vary proportion
			VaryAboutAdd (1, m_nProportion, 99, 10, pnarray, POINTS_TO_GRAPH);
			// Now calculate the sample sizes
            
			for(int i = 0; i < POINTS_TO_GRAPH; i++)
			{
				
				pCalcArray[i].m_nProportion = pnarray[i];
				pCalcArray[i].Calculate();
                
				// assign the proportion to the graph dialog
				dlg.m_pfGraphDataArray[0][i] = (float)pCalcArray[i].m_nn;
				// now assign the proportion to the x axis as a word
				//TRACE("Cluster::Graph before assignment: dlg.m_pszXAxisLabelArray[%d] is %s.\n", i, dlg.m_pszXAxisLabelArray[i]);
				sprintf(dlg.m_pszXAxisLabelArray[i],"%d%%", pCalcArray[i].m_nProportion);
				//TRACE("Cluster::Graph after assignment: dlg.m_pszXAxisLabelArray[%d] is %s.\n", i, dlg.m_pszXAxisLabelArray[i]);
				//		char szmess[80];
                //		sprintf(szmess, "Cluster::graph: Calc[%d] is %d fGraphData[%d] is %f.", i, pCalcArray[i].m_nClusters, i, dlg.m_pfGraphDataArray[i]);
                //		AfxMessageBox(szmess);
			}
			break;
		} // PROPORTION
		case CONFIDENCE_INTERVAL:
		{
			// Create the title
			sprintf(dlg.m_szGraphTitle, "Cluster Sample: Proportion %d%%, CC %d%%, Cluster Size %d, ROH %s ",
                    m_nProportion, m_nConfidenceLevel, m_nb, m_csroh);
			sprintf(dlg.m_szBottomTitle, "Confidence Interval");
            //	int* pnarray = new int[POINTS_TO_GRAPH];
			// Choose arbitrary factor of 10 to vary proportion
			VaryAboutAdd (1, m_nConfidenceInterval, 20, 2, pnarray, POINTS_TO_GRAPH);
			// Now calculate the sample sizes
			
			for(int i = 0; i < POINTS_TO_GRAPH; i++)
			{
				pCalcArray[i].m_nConfidenceInterval = pnarray[i];
				pCalcArray[i].Calculate();
				dlg.m_pfGraphDataArray[0][i] = (float)pCalcArray[i].m_nn;
                // Set x axis labels
				
				//cs.Format("%d", pCalcArray[i].m_nn);
				sprintf(dlg.m_pszXAxisLabelArray[i],"%c%d%%", 177, pCalcArray[i].m_nConfidenceInterval);
                //.Format("%d",pCalcArray[i].m_nn);
			}
			break;
		}  // CONFIDENCE_INTERVAL
            
		case CONFIDENCE_LEVEL:
		{
			// Create the title
			sprintf(dlg.m_szGraphTitle, "Cluster Sample: Proportion %d%%, 95%% CI %c%d%%, Cluster Size %d, ROH %s",
                    m_nProportion, 177, m_nConfidenceInterval, m_nb, m_csroh);
			sprintf(dlg.m_szBottomTitle,"Confidence Coeffecient");
			
			// Choose arbitrary factor of 10 to vary proportion
			VaryAboutAdd (80, m_nConfidenceLevel, 99, 2, pnarray, POINTS_TO_GRAPH);
			// Now calculate the sample sizes
			
			for(int i = 0; i < POINTS_TO_GRAPH; i++)
			{
				pCalcArray[i].m_nConfidenceLevel = pnarray[i];
				pCalcArray[i].Calculate();
				dlg.m_pfGraphDataArray[0][i] = (float)pCalcArray[i].m_nn;
                // Set x axis labels
				
				//cs.Format("%d", pCalcArray[i].m_nn);
				sprintf(dlg.m_pszXAxisLabelArray[i],"%d%%", pCalcArray[i].m_nConfidenceLevel);
                //.Format("%d",pCalcArray[i].m_nn);
			} // for
            break;
		} // CONFIDENCE_LEVEL
            
		case CLUSTER_SIZE:
		{
			// Create the title
            /** start here**/		sprintf(dlg.m_szGraphTitle, "Cluster Sample: Proportion %d%%, 95%% CI %c%d%%, CC %d%%, ROH %s",
                                            m_nProportion, 177, m_nConfidenceInterval, m_nConfidenceLevel, m_csroh);
			sprintf(dlg.m_szBottomTitle, "Cluster Size");
			
			// Choose arbitrary factor of 10 to vary proportion
			VaryAboutAdd (1, m_nb, 200, 5, pnarray, POINTS_TO_GRAPH);
			// Now calculate the sample sizes
			
			for(int i = 0; i < POINTS_TO_GRAPH; i++)
			{
				pCalcArray[i].m_nb = pnarray[i];
				pCalcArray[i].Calculate();
				dlg.m_pfGraphDataArray[0][i] = (float)pCalcArray[i].m_nn;
                // Set x axis labels
				
				//cs.Format("%d", pCalcArray[i].m_nn);
				sprintf(dlg.m_pszXAxisLabelArray[i],"%d%", pCalcArray[i].m_nb);
                //.Format("%d",pCalcArray[i].m_nn);
			} // for
			break;
		} // CLUSTER_SIZE
            
		case ROH:
		{
			// Create the title
			// Finally, it looks like overflow of the title here was the cause of the mysterious malfunctions?!
			sprintf(dlg.m_szGraphTitle, "Cluster Sample: Proportion %d%%, 95%% CI %c%d%%, CC %d%% Cluster Size %d",
                    m_nProportion, 177, m_nConfidenceInterval, m_nConfidenceLevel, m_nb);
			sprintf(dlg.m_szBottomTitle,"ROH");
			
			// Choose arbitrary factor of 10 to vary proportion
			VaryAboutAdd ((double)0, m_droh, (double)1, 0.1, pdarray, POINTS_TO_GRAPH);
			// Now calculate the sample sizes
			
			for(int i = 0; i < POINTS_TO_GRAPH; i++)
			{
				pCalcArray[i].m_droh = pdarray[i];
				pCalcArray[i].Calculate();
				dlg.m_pfGraphDataArray[0][i] = (float)pCalcArray[i].m_nn;
                // Set x axis labels
				
				//cs.Format("%d", pCalcArray[i].m_nn); 
				sprintf(dlg.m_pszXAxisLabelArray[i],"%1.2f", (float)pCalcArray[i].m_droh);
                //.Format("%d",pCalcArray[i].m_nn);
                
			} // for
			break;
		} // ROH 
            
	}  // switch
    
    
    // Clean up to avoid memory leaks
	delete[] pnarray;
	delete[] pCalcArray;
	delete[] pdarray;
	delete[] plarray;
    
	return TRUE;
}  //Graph()

int CCluster::GetUserAssumptionToVary(void)
{
    
	CVaryAssumptionsDialog dlg;
	dlg.m_nRadioChoice = m_nUserAssumptionsRadioChoice;
	if ( dlg.DoModal() == IDOK)
	{
		m_nUserAssumptionsRadioChoice = dlg.m_nRadioChoice;
		return m_nUserAssumptionsRadioChoice;
	}
	else // user cancelled
		return USER_CANCELLED;
    
	
}