package org.lamport.tla.toolbox.tool.prover.output;

import org.eclipse.core.runtime.IPath;

/**
 * Plug-ins can attach to the extension point org.lamport.tla.toolbox.tool.prover.processOutputSink
 * using an implementation of this interface to receive streaming output from the prover.
 * 
 * @author Daniel Ricketts
 *
 */
public interface IProverProcessOutputSink
{
    /**
     * Debug stream
     */
    public final static int TYPE_DEBUG = -1;
    /**
     * Output stream
     */
    public final static int TYPE_OUT = 1;
    /**
     * Error stream 
     */
    public final static int TYPE_ERROR = 2;
    /**
     * Extension point the interface is used in.
     * 
     * Plugins can attach to this extension point using a class implementing
     * this interface to receive streaming output from the prover.
     */
    public static final String EXTENSION_ID = "org.lamport.tla.toolbox.tool.prover.processOutputSink";

    /**
     * Appends text to the sink.
     * 
     * @param text 
     */
    public void appendText(String text);

    /**
     * Called prior to appending text. Allows the sink to perform any
     * necessary initialization before receiving output from the prover.
     * 
     * The name of the process could be anything. However, if it is the
     * launch of the prover on a specific module, it should be a string
     * representation of the full file system path to that module
     * generated by calling {@link IPath#toPortableString()}.
     * 
     * @param processName the name of the process
     * @param sinkType type, see constants {@link IProcessOutputSink#TYPE_DEBUG}, {@link IProcessOutputSink#TYPE_ERROR}, {@link IProcessOutputSink#TYPE_OUT}, {@link IProcessOutputSink#TYPE_TRACE_EXPLORE}
     */
    public void initializeSink(String processName, int sinkType);

    /**
     * Signal to the sink that the prover process has terminated and no data will be sent.
     */
    public void processFinished();

}
