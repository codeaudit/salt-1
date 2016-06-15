package org.corpus_tools.salt.util.internal;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.util.DiffOptions;
import org.corpus_tools.salt.util.SaltUtil;
import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class CorpusStructureDiffTest {

	private CorpusStructureDiff fixture;
	private SCorpusGraph template;
	private SCorpusGraph other;
	private DiffOptions options;
	
	@Before
	public void beforeEach(){
		template= SaltFactory.createSCorpusGraph();
		other= SaltFactory.createSCorpusGraph();
		options= new DiffOptions();
		
		fixture= new CorpusStructureDiff(template, other, options);
	}
	
	@Test
	public void whenTwoCorpusStructuresAreIdentical_thenTheyAreIsomorphAndHaveNoDifferences(){
		template.createDocument(URI.createURI("/corpus1/corpus2/document1"));
		template.createDocument(URI.createURI("/corpus1/corpus2/document2"));
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4"));
		
		other.createDocument(URI.createURI("/corpus1/corpus2/document1"));
		other.createDocument(URI.createURI("/corpus1/corpus2/document2"));
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4"));
		
		assertThat(SaltUtil.compare(template).with(other).useOption(DiffOptions.OPTION_IGNORE_NAME, false).andCheckIsomorphie()).isTrue();
		assertThat(SaltUtil.compare(template).with(other).useOption(DiffOptions.OPTION_IGNORE_NAME, false).andFindDiffs()).isEmpty();
	}
	
	@Test
	public void whenTwoCorpusStructuresWithDocumentsAreIdentical_thenTheyAreIsomorphAndHaveNoDifferences(){
		template.createDocument(URI.createURI("/corpus1/corpus2/document1")).createDocumentGraph();
		template.createDocument(URI.createURI("/corpus1/corpus2/document2")).createDocumentGraph().createTextualDS("sample text");
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3")).createDocumentGraph();
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4")).createDocumentGraph().createTextualDS("sample text");
		
		other.createDocument(URI.createURI("/corpus1/corpus2/document1")).createDocumentGraph();
		other.createDocument(URI.createURI("/corpus1/corpus2/document2")).createDocumentGraph().createTextualDS("sample text");
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3")).createDocumentGraph();
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4")).createDocumentGraph().createTextualDS("sample text");
		
		assertThat(SaltUtil.compare(template).with(other).useOption(DiffOptions.OPTION_IGNORE_NAME, false).andCheckIsomorphie()).isTrue();
		assertThat(SaltUtil.compare(template).with(other).useOption(DiffOptions.OPTION_IGNORE_NAME, false).andFindDiffs()).isEmpty();
	}
	
	@Test
	public void whenTwoCorpusStructuresAreIdenticalButDocumentStructuresDont_thenTheyAreNotIsomorphAndHaveDifferences(){
		template.createDocument(URI.createURI("/corpus1/corpus2/document1")).createDocumentGraph();
		template.createDocument(URI.createURI("/corpus1/corpus2/document2")).createDocumentGraph().createTextualDS("sample text");
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3")).createDocumentGraph();
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4")).createDocumentGraph().createTextualDS("sample text");
		
		other.createDocument(URI.createURI("/corpus1/corpus2/document1")).createDocumentGraph().createTextualDS("sample text");
		other.createDocument(URI.createURI("/corpus1/corpus2/document2")).createDocumentGraph();
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3")).createDocumentGraph().createTextualDS("sample text");
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4")).createDocumentGraph();
		
		assertThat(SaltUtil.compare(template).with(other).useOption(DiffOptions.OPTION_IGNORE_NAME, false).andCheckIsomorphie()).isFalse();
		assertThat(SaltUtil.compare(template).with(other).useOption(DiffOptions.OPTION_IGNORE_NAME, false).andFindDiffs()).hasSize(4);
	}
	
	@Test
	public void whenTwoCorpusStructuresAreNotIdentical_thenTheyAreNotIsomorphAndHaveDifferences(){
		template.createDocument(URI.createURI("/corpus1/corpus2/document1"));
		template.createDocument(URI.createURI("/corpus1/corpus2/document2"));
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document5"));
		
		other.createDocument(URI.createURI("/corpus1/corpus2/document1"));
		other.createDocument(URI.createURI("/corpus1/corpus2/document2"));
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4"));
		
		assertThat(SaltUtil.compare(template).with(other).useOption(DiffOptions.OPTION_IGNORE_NAME, false).andCheckIsomorphie()).isFalse();
		assertThat(SaltUtil.compare(template).with(other).useOption(DiffOptions.OPTION_IGNORE_NAME, false).andFindDiffs()).hasSize(1);
	}

	@Test
	public void whenTwoCorpusStructuresWithMultipleRootsAreIdentical_thenTheyAreIsomorphAndHaveNoDifferences(){
		template.createDocument(URI.createURI("/corpus1/corpus2/document1"));
		template.createDocument(URI.createURI("/corpus1/corpus2/document2"));
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4"));
		template.createDocument(URI.createURI("/corpus4/corpus5/document5"));
		
		other.createDocument(URI.createURI("/corpus1/corpus2/document1"));
		other.createDocument(URI.createURI("/corpus1/corpus2/document2"));
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4"));
		other.createDocument(URI.createURI("/corpus4/corpus5/document5"));
		
		assertThat(SaltUtil.compare(template).with(other).useOption(DiffOptions.OPTION_IGNORE_NAME, false).andCheckIsomorphie()).isTrue();
		assertThat(SaltUtil.compare(template).with(other).useOption(DiffOptions.OPTION_IGNORE_NAME, false).andFindDiffs()).isEmpty();
	}
	
	@Test
	public void whenComparingOneCorpusStructureWithMultipleRootsAndOneWithout_thenTheyAreNotIsomorphAndHaveDifferences(){
		template.createDocument(URI.createURI("/corpus1/corpus2/document1"));
		template.createDocument(URI.createURI("/corpus1/corpus2/document2"));
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		template.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4"));
		template.createDocument(URI.createURI("/corpus4/corpus5/document5"));
		
		other.createDocument(URI.createURI("/corpus1/corpus2/document1"));
		other.createDocument(URI.createURI("/corpus1/corpus2/document2"));
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		other.createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4"));
		
		assertThat(SaltUtil.compare(template).with(other).useOption(DiffOptions.OPTION_IGNORE_NAME, false).andCheckIsomorphie()).isFalse();
		assertThat(SaltUtil.compare(template).with(other).useOption(DiffOptions.OPTION_IGNORE_NAME, false).andFindDiffs()).hasSize(1);
	}
}
