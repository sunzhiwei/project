/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) radix(10) lradix(10) 
// Source File Name:   WSDL2.java

package org.apache.axis.wsdl.gen;

import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.axis.utils.CLArgsParser;
import org.apache.axis.utils.CLOption;
import org.apache.axis.utils.CLOptionDescriptor;
import org.apache.axis.utils.CLUtil;
import org.apache.axis.utils.DefaultAuthenticator;
import org.apache.axis.utils.Messages;

// Referenced classes of package org.apache.axis.wsdl.gen:
//            Parser

public class WSDL2 {

	protected WSDL2() {
		wsdlURI = null;
		parser = createParser();
	}

	protected Parser createParser() {
		return new Parser();
	}

	protected Parser getParser() {
		return parser;
	}

	protected void addOptions(CLOptionDescriptor newOptions[]) {
		if (newOptions != null && newOptions.length > 0) {
			CLOptionDescriptor allOptions[] = new CLOptionDescriptor[options.length
					+ newOptions.length];
			System.arraycopy(options, 0, allOptions, 0, options.length);
			System.arraycopy(newOptions, 0, allOptions, options.length,
					newOptions.length);
			options = allOptions;
		}
	}

	protected void removeOption(String name) {
		int foundOptionIndex = -1;
		int i = 0;
		do {
			if (i >= options.length)
				break;
			if (options[i].getName().equals(name)) {
				foundOptionIndex = i;
				break;
			}
			i++;
		} while (true);
		if (foundOptionIndex != -1) {
			CLOptionDescriptor newOptions[] = new CLOptionDescriptor[options.length - 1];
			System.arraycopy(options, 0, newOptions, 0, foundOptionIndex);
			if (foundOptionIndex < newOptions.length)
				System.arraycopy(options, foundOptionIndex + 1, newOptions,
						foundOptionIndex, newOptions.length - foundOptionIndex);
			options = newOptions;
		}
	}

	protected void parseOption(CLOption option) {
		switch (option.getId()) {
		default:
			break;

		case 0: // '\0'
			if (wsdlURI != null) {
				System.out.println(Messages.getMessage("w2jDuplicateWSDLURI00",
						wsdlURI, option.getArgument()));
				printUsage();
			}
			wsdlURI = option.getArgument();
			break;

		case 104: // 'h'
			printUsage();
			break;

		case 110: // 'n'
			parser.setImports(false);
			break;

		case 79: // 'O'
			String timeoutValue = option.getArgument();
			long timeout = Long.parseLong(timeoutValue);
			if (timeout > 0L)
				timeout *= 1000L;
			parser.setTimeout(timeout);
			break;

		case 118: // 'v'
			parser.setVerbose(true);
			break;

		case 68: // 'D'
			parser.setDebug(true);
			break;

		case 113: // 'q'
			parser.setQuiet(true);
			break;

		case 87: // 'W'
			parser.setNowrap(true);
			break;
		}
	}

	protected void validateOptions() {
		if (wsdlURI == null) {
			System.out.println(Messages.getMessage("w2jMissingWSDLURI00"));
			printUsage();
		}
		if (parser.isQuiet()) {
			if (parser.isVerbose()) {
				System.out
						.println(Messages.getMessage("exclusiveQuietVerbose"));
				printUsage();
			}
			if (parser.isDebug()) {
				System.out.println(Messages.getMessage("exclusiveQuietDebug"));
				printUsage();
			}
		}
		checkForAuthInfo(wsdlURI);
		Authenticator.setDefault(new DefaultAuthenticator(parser.getUsername(),
				parser.getPassword()));
	}

	private void checkForAuthInfo(String uri) {
		URL url = null;
		try {
			url = new URL(uri);
		} catch (MalformedURLException e) {
			return;
		}
		String userInfo = url.getUserInfo();
		if (userInfo != null) {
			int i = userInfo.indexOf(':');
			if (i >= 0) {
				parser.setUsername(userInfo.substring(0, i));
				parser.setPassword(userInfo.substring(i + 1));
			} else {
				parser.setUsername(userInfo);
			}
		}
	}

	protected void printUsage() {
		String lSep = System.getProperty("line.separator");
		StringBuffer msg = new StringBuffer();
		msg.append(
				Messages.getMessage("usage00", "java " + getClass().getName()
						+ " [options] WSDL-URI")).append(lSep);
		msg.append(Messages.getMessage("options00")).append(lSep);
		msg.append(CLUtil.describeOptions(options).toString());
		System.out.println(msg.toString());
		System.exit(1);
	}

	protected void run(String args[]) {
		CLArgsParser argsParser = new CLArgsParser(args, options);
		if (null != argsParser.getErrorString()) {
			System.err.println(Messages.getMessage("error01", argsParser
					.getErrorString()));
			printUsage();
		}
		List clOptions = argsParser.getArguments();
		int size = clOptions.size();
		try {
			for (int i = 0; i < size; i++)
				parseOption((CLOption) clOptions.get(i));

			validateOptions();
			parser.run(wsdlURI);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static void main(String args[]) {
		WSDL2 wsdl2 = new WSDL2();
		wsdl2.run(args);
	}

	protected static final int DEBUG_OPT = 68;
	protected static final int HELP_OPT = 104;
	protected static final int NETWORK_TIMEOUT_OPT = 79;
	protected static final int NOIMPORTS_OPT = 110;
	protected static final int VERBOSE_OPT = 118;
	protected static final int NOWRAP_OPT = 87;
	protected static final int QUIET_OPT = 113;
	protected CLOptionDescriptor options[] = {
			new CLOptionDescriptor("help", 8, 104, Messages
					.getMessage("optionHelp00")),
			new CLOptionDescriptor("verbose", 8, 118, Messages
					.getMessage("optionVerbose00")),
			new CLOptionDescriptor("noImports", 8, 110, Messages
					.getMessage("optionImport00")),
			new CLOptionDescriptor("timeout", 2, 79, Messages
					.getMessage("optionTimeout00")),
			new CLOptionDescriptor("Debug", 8, 68, Messages
					.getMessage("optionDebug00")),
			new CLOptionDescriptor("noWrapped", 8, 87, Messages
					.getMessage("optionNoWrap00")),
			new CLOptionDescriptor("quiet", 8, 113, Messages
					.getMessage("optionQuiet")) };
	protected String wsdlURI;
	protected Parser parser;
}
