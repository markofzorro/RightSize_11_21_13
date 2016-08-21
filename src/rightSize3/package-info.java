/**
 */


/**
 * RightSize3
 * 
 * @author markofzero
 * 
 * <p>A program to help filed epidemiologists learn to design surveys. It shows the effects of changed
 * assumptions and includes a detailed case study of a cluster survey in Vietnam.
 * 
 * <p>We use a document-view pattern, where the document controls views, does calculations, and stores data. 
 * The view paints screens and handles user interactions.
 * 
 *  <p>to calculate sample sizes, the document gets user input from the view, calls a calculator object to generate
 *  results, and sends results to the view for display.
 *  
 *  <p>Charts are more complex since they display several alternative assumptions and show how variations affect required sample sizes.
 *  The document instantiates a ChartDocument object, which produces the chart and shows it. It calls its corresponding Variations object
 *  which produces an array of values and returns them to the ChartDocument. The document then iterates through the array and calculates
 *  sample sizes for each variation. It fills these into the array used as input to the chart and generates the chart. It passes the chart to
 *  a JTabbedFrame for display.
 * 
 * 
 * 
 */
package rightSize3;
