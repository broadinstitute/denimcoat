package denimcoat.reasoners.mvp

object MonarchInitiativeSampleResponseJson {

  val responseString: String =
    Seq(
      part00, part01, part02, part03, part04, part05, part06, part07, part08, part09, part10, part11, part12,
      part13, part14
    ).mkString("\n")

  def part00: String =
"""
{
  "facet_counts": {
    "subject_closure": {
      "IAO:0000030": 209,
      "HP:0000001": 209,
      "HP:0000118": 209,
      "GO:0042593PHENOTYPE": 209,
      "IAO:0000300": 209,
      "HP:0001939": 209,
      "GO:0033500PHENOTYPE": 209,
      "IAO:0000144": 209,
      "BFO:0000001": 209,
      "HP:0011014": 209,
      "GO:0008150PHENOTYPE": 209,
      "MP:0000001": 209,
      "GO:0044238PHENOTYPE": 209,
      "GO:0042592PHENOTYPE": 209,
      "BFO:0000031": 209,
      "BFO:0000020": 209,
      "GO:0048878PHENOTYPE": 209,
      "GO:0065008PHENOTYPE": 209,
      "HP:0011013": 209,
      "HP:0000855": 209,
      "BFO:0000002": 209,
      "MP:0001764": 209,
      "GO:0071704PHENOTYPE": 209,
      "HP:0012337": 209,
      "GO:0005975PHENOTYPE": 209
    },
    "object_taxon_label": {}
  },
  "compact_associations": null,
  "highlighting": null,
  "associations": [
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "hyperinsulinism (disease)",
        "id": "MONDO:0002177"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "a59811bb-b056-492d-bed9-f9980c906030",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONARCH:896c2bbab86e9331",
            "lbl": null
          },
          {
            "id": "PMID:10444811",
            "lbl": null
          },
          {
            "id": "PMID:19376581",
            "lbl": null
          },
          {
            "id": "PMID:12130701",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "PMID:19724224",
            "lbl": null
          },
          {
            "id": "PMID:6275548",
            "lbl": null
          },
          {
            "id": "MONDO:0002177",
            "lbl": "hyperinsulinism (disease)"
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0002177",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:896c2bbab86e9331",
            "obj": "PMID:12130701",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:896c2bbab86e9331",
            "obj": "PMID:10444811",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:896c2bbab86e9331",
            "obj": "PMID:19376581",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:896c2bbab86e9331",
            "obj": "PMID:19724224",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:896c2bbab86e9331",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:896c2bbab86e9331",
            "obj": "PMID:6275548",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:896c2bbab86e9331",
            "obj": "MONDO:0002177",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:896c2bbab86e9331",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:12130701",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:10444811",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19376581",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19724224",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:6275548",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "breast cancer",
        "id": "MONDO:0007254"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "df51264c-45eb-4975-b6ab-dd29ffd13952",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:17531933",
            "lbl": null
          },
          {
            "id": "PMID:15242694",
            "lbl": null
          },
          {
            "id": "PMID:12766105",
            "lbl": null
          },
          {
            "id": "MONDO:0007254",
            "lbl": "breast cancer"
          },
          {
            "id": "MONARCH:e3cf9037ef6667fd",
            "lbl": null
          },
          {
            "id": "PMID:21413010",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          },
          {
            "id": "PMID:11443175",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:e3cf9037ef6667fd",
            "obj": "PMID:21413010",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0007254",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:e3cf9037ef6667fd",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:e3cf9037ef6667fd",
            "obj": "PMID:12766105",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:e3cf9037ef6667fd",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:e3cf9037ef6667fd",
            "obj": "PMID:17531933",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:e3cf9037ef6667fd",
            "obj": "PMID:11443175",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:e3cf9037ef6667fd",
            "obj": "PMID:15242694",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:e3cf9037ef6667fd",
            "obj": "MONDO:0007254",
            "pred": "OBAN:association_has_subject"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:15242694",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21413010",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:11443175",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:12766105",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17531933",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "pituitary gland adenoma",
        "id": "MONDO:0006373"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "087d8bb1-a408-4abd-aa70-527cd4121905",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0006373",
            "lbl": "pituitary gland adenoma"
          },
          {
            "id": "PMID:9536592",
            "lbl": null
          },
          {
            "id": "PMID:16603725",
            "lbl": null
          },
          {
            "id": "PMID:18063933",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONARCH:f54456a25ffeb681",
            "lbl": null
          },
          {
            "id": "PMID:9447299",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          },
          {
            "id": "PMID:18160471",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:f54456a25ffeb681",
            "obj": "PMID:18160471",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:f54456a25ffeb681",
            "obj": "PMID:9447299",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:f54456a25ffeb681",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONDO:0006373",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:f54456a25ffeb681",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:f54456a25ffeb681",
            "obj": "PMID:16603725",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:f54456a25ffeb681",
            "obj": "PMID:9536592",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:f54456a25ffeb681",
            "obj": "PMID:18063933",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:f54456a25ffeb681",
            "obj": "MONDO:0006373",
            "pred": "OBAN:association_has_subject"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:9536592",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:18160471",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:9447299",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:18063933",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:16603725",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "PLIN1-related familial partial lipodystrophy",
        "id": "MONDO:0013478"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "ba0153e1-1207-456c-8a01-1cb5c3b7aa4e",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "HP:0040280",
            "lbl": "Obligate"
          },
          {
            "id": "MONARCH:856df38000ff0148",
            "lbl": null
          },
          {
            "id": "HP:0000877",
            "lbl": "Insulin-resistant diabetes mellitus at puberty"
          },
          {
            "id": "MONDO:0013478",
            "lbl": "PLIN1-related familial partial lipodystrophy"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0013478",
            "obj": "HP:0000877",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:856df38000ff0148",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:856df38000ff0148",
            "obj": "HP:0000877",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:856df38000ff0148",
            "obj": "MONDO:0013478",
            "pred": "OBAN:association_has_subject"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus at puberty",
        "id": "HP:0000877"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "congenital generalized lipodystrophy type 2",
        "id": "MONDO:0010020"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "8c999b5b-ffb7-412a-b9ef-eb8a1b57e56e",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0010020",
            "lbl": "congenital generalized lipodystrophy type 2"
          },
          {
            "id": "HP:0000877",
            "lbl": "Insulin-resistant diabetes mellitus at puberty"
          },
          {
            "id": "MONARCH:cc9b11d3a54ffaa5",
            "lbl": null
          },
          {
            "id": "ECO:0000501",
            "lbl": "evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0010020",
            "obj": "HP:0000877",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:cc9b11d3a54ffaa5",
            "obj": "MONDO:0010020",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:cc9b11d3a54ffaa5",
            "obj": "ECO:0000501",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:cc9b11d3a54ffaa5",
            "obj": "HP:0000877",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus at puberty",
        "id": "HP:0000877"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "arteriosclerosis (disease)",
        "id": "MONDO:0002277"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "6b1c065c-4ff3-4379-b65f-2fd607b1c819",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0002277",
            "lbl": "arteriosclerosis (disease)"
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "PMID:12145764",
            "lbl": null
          },
          {
            "id": "PMID:14683455",
            "lbl": null
          },
          {
            "id": "PMID:3289862",
            "lbl": null
          },
          {
            "id": "PMID:14556455",
            "lbl": null
          },
          {
            "id": "MONARCH:c45f31359955cab7",
            "lbl": null
          },
          {
            "id": "PMID:10399372",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:c45f31359955cab7",
            "obj": "PMID:14683455",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:c45f31359955cab7",
            "obj": "PMID:10399372",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:c45f31359955cab7",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:c45f31359955cab7",
            "obj": "PMID:14556455",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:c45f31359955cab7",
            "obj": "MONDO:0002277",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONDO:0002277",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:c45f31359955cab7",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:c45f31359955cab7",
            "obj": "PMID:3289862",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:c45f31359955cab7",
            "obj": "PMID:12145764",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:3289862",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:14683455",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:10399372",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:12145764",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:14556455",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Bangstad syndrome",
        "id": "MONDO:0008874"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "8b4e23d6-e74a-4b41-b096-7299beee3bfb",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0008874",
            "lbl": "Bangstad syndrome"
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "MONARCH:190d63b01bdca2d5",
            "lbl": null
          },
          {
            "id": "ECO:0000501",
            "lbl": "evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:190d63b01bdca2d5",
            "obj": "MONDO:0008874",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:190d63b01bdca2d5",
            "obj": "ECO:0000501",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONDO:0008874",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:190d63b01bdca2d5",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "arteriolosclerosis",
        "id": "MONDO:0006658"
      },
      "relation": {
"""
  def part01: String =
"""
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "bf71fc09-6417-4e4b-a912-b7120cddd219",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0006658",
            "lbl": "arteriolosclerosis"
          },
          {
            "id": "PMID:23428921",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONARCH:6250bf23bc3f3faa",
            "lbl": null
          },
          {
            "id": "PMID:20186145",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0006658",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:6250bf23bc3f3faa",
            "obj": "MONDO:0006658",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:6250bf23bc3f3faa",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:6250bf23bc3f3faa",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:6250bf23bc3f3faa",
            "obj": "PMID:23428921",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:6250bf23bc3f3faa",
            "obj": "PMID:20186145",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:23428921",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20186145",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "renal hypertension",
        "id": "MONDO:0001105"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "59c02bdf-27ee-40d8-8862-9bb830eb62bd",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:12797596",
            "lbl": null
          },
          {
            "id": "MONDO:0001105",
            "lbl": "renal hypertension"
          },
          {
            "id": "PMID:10821335",
            "lbl": null
          },
          {
            "id": "MONARCH:e1932817196302ef",
            "lbl": null
          },
          {
            "id": "PMID:16470357",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:7566576",
            "lbl": null
          },
          {
            "id": "PMID:21816148",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:e1932817196302ef",
            "obj": "PMID:16470357",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:e1932817196302ef",
            "obj": "PMID:7566576",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0001105",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:e1932817196302ef",
            "obj": "PMID:10821335",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:e1932817196302ef",
            "obj": "MONDO:0001105",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:e1932817196302ef",
            "obj": "PMID:12797596",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:e1932817196302ef",
            "obj": "PMID:21816148",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:e1932817196302ef",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:e1932817196302ef",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:16470357",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:12797596",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:10821335",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21816148",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:7566576",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "alcohol abuse",
        "id": "MONDO:0002046"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "fbb7d57d-df78-4db3-849f-1ecf5d74f903",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:15250029",
            "lbl": null
          },
          {
            "id": "PMID:20855893",
            "lbl": null
          },
          {
            "id": "PMID:20470213",
            "lbl": null
          },
          {
            "id": "MONDO:0002046",
            "lbl": "alcohol abuse"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:3515866",
            "lbl": null
          },
          {
            "id": "MONARCH:2448af1a0f0efcd6",
            "lbl": null
          },
          {
            "id": "PMID:20935521",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:2448af1a0f0efcd6",
            "obj": "PMID:3515866",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:2448af1a0f0efcd6",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:2448af1a0f0efcd6",
            "obj": "PMID:20935521",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:2448af1a0f0efcd6",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:2448af1a0f0efcd6",
            "obj": "PMID:15250029",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:2448af1a0f0efcd6",
            "obj": "PMID:20855893",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:2448af1a0f0efcd6",
            "obj": "MONDO:0002046",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:2448af1a0f0efcd6",
            "obj": "PMID:20470213",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0002046",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:15250029",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20935521",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:3515866",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20470213",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20855893",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Werner syndrome",
        "id": "MONDO:0010196"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "18076035-d0f1-4c38-8dd0-c1e0edc1020e",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:22188495",
            "lbl": null
          },
          {
            "id": "MONARCH:1b87625cf50e211b",
            "lbl": null
          },
          {
            "id": "PMID:2477323",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "MONDO:0010196",
            "lbl": "Werner syndrome"
          },
          {
            "id": "PMID:16174718",
            "lbl": null
          },
          {
            "id": "PMID:7599691",
            "lbl": null
          },
          {
            "id": "PMID:11410834",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:1b87625cf50e211b",
            "obj": "PMID:16174718",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1b87625cf50e211b",
            "obj": "MONDO:0010196",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:1b87625cf50e211b",
            "obj": "PMID:2477323",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1b87625cf50e211b",
            "obj": "PMID:7599691",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1b87625cf50e211b",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:1b87625cf50e211b",
            "obj": "PMID:11410834",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1b87625cf50e211b",
            "obj": "PMID:22188495",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0010196",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:1b87625cf50e211b",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:11410834",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:2477323",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:16174718",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:7599691",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22188495",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "severe neurodegenerative syndrome with lipodystrophy",
        "id": "MONDO:0014402"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "ba57b6cd-0ac6-4bcf-a358-bffc4d9eae83",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "MONDO:0014402",
            "lbl": "severe neurodegenerative syndrome with lipodystrophy"
          },
          {
            "id": "MONARCH:76a2da0b6943f353",
            "lbl": null
          },
          {
            "id": "HP:0040281",
            "lbl": "Very frequent"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0014402",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:76a2da0b6943f353",
            "obj": "MONDO:0014402",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:76a2da0b6943f353",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:76a2da0b6943f353",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "HIV infection",
        "id": "MONDO:0005109"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "9dd29afb-f862-4cea-8c20-ed367805e72b",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONARCH:6133809e9e8a0554",
            "lbl": null
          },
          {
            "id": "PMID:18366987",
            "lbl": null
          },
          {
            "id": "PMID:16432707",
            "lbl": null
          },
          {
            "id": "PMID:15242534",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:12395531",
            "lbl": null
          },
          {
            "id": "PMID:17325603",
            "lbl": null
          },
          {
            "id": "MONDO:0005109",
            "lbl": "HIV infection"
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:6133809e9e8a0554",
            "obj": "MONDO:0005109",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:6133809e9e8a0554",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:6133809e9e8a0554",
            "obj": "PMID:17325603",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0005109",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:6133809e9e8a0554",
            "obj": "PMID:16432707",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:6133809e9e8a0554",
            "obj": "PMID:15242534",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:6133809e9e8a0554",
            "obj": "PMID:18366987",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:6133809e9e8a0554",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:6133809e9e8a0554",
            "obj": "PMID:12395531",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:17325603",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:16432707",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:18366987",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:12395531",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15242534",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "morbid obesity",
        "id": "MONDO:0005139"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "93f4ebdd-d749-475a-bead-64f799c25e70",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONARCH:a088295153f484cd",
            "lbl": null
          },
          {
            "id": "PMID:21685273",
            "lbl": null
          },
          {
            "id": "PMID:16088092",
            "lbl": null
          },
          {
            "id": "MONDO:0005139",
            "lbl": "morbid obesity"
          },
          {
            "id": "PMID:12370103",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:21386801",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          },
          {
            "id": "PMID:1528585",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:a088295153f484cd",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:a088295153f484cd",
            "obj": "MONDO:0005139",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:a088295153f484cd",
            "obj": "PMID:16088092",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a088295153f484cd",
            "obj": "PMID:12370103",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a088295153f484cd",
            "obj": "PMID:21685273",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a088295153f484cd",
            "obj": "PMID:21386801",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a088295153f484cd",
            "obj": "PMID:1528585",
            "pred": "dc:source"
"""
  def part02: String =
"""
          },
          {
            "sub": "MONDO:0005139",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:a088295153f484cd",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:21386801",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21685273",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:12370103",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:1528585",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:16088092",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "familial multiple lipomatosis",
        "id": "MONDO:0007909"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "23c89b40-c032-430d-92a2-34d96dcb2e00",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONARCH:37ec4346f1a18f9f",
            "lbl": null
          },
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "MONDO:0007909",
            "lbl": "familial multiple lipomatosis"
          },
          {
            "id": "HP:0040281",
            "lbl": "Very frequent"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0007909",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:37ec4346f1a18f9f",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:37ec4346f1a18f9f",
            "obj": "MONDO:0007909",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:37ec4346f1a18f9f",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "congestive heart failure",
        "id": "MONDO:0005009"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "56c24c33-bf07-41bf-96fb-77128097b18f",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:15865863",
            "lbl": null
          },
          {
            "id": "PMID:15331318",
            "lbl": null
          },
          {
            "id": "PMID:17456982",
            "lbl": null
          },
          {
            "id": "PMID:20118174",
            "lbl": null
          },
          {
            "id": "MONDO:0005009",
            "lbl": "congestive heart failure"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONARCH:9c2c1ab1e02820f9",
            "lbl": null
          },
          {
            "id": "PMID:17395047",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0005009",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:9c2c1ab1e02820f9",
            "obj": "MONDO:0005009",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:9c2c1ab1e02820f9",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:9c2c1ab1e02820f9",
            "obj": "PMID:15331318",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:9c2c1ab1e02820f9",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:9c2c1ab1e02820f9",
            "obj": "PMID:20118174",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:9c2c1ab1e02820f9",
            "obj": "PMID:17456982",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:9c2c1ab1e02820f9",
            "obj": "PMID:17395047",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:9c2c1ab1e02820f9",
            "obj": "PMID:15865863",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:17395047",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15331318",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15865863",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20118174",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17456982",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "marasmus",
        "id": "MONDO:0006848"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "601e66f5-8f63-475f-af38-48fd0c9a5b3d",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONARCH:3b4f482e9161c42c",
            "lbl": null
          },
          {
            "id": "PMID:19859052",
            "lbl": null
          },
          {
            "id": "PMID:808679",
            "lbl": null
          },
          {
            "id": "PMID:9350678",
            "lbl": null
          },
          {
            "id": "PMID:22386944",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONDO:0006848",
            "lbl": "marasmus"
          },
          {
            "id": "PMID:20017836",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:3b4f482e9161c42c",
            "obj": "PMID:808679",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0006848",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:3b4f482e9161c42c",
            "obj": "PMID:20017836",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:3b4f482e9161c42c",
            "obj": "PMID:9350678",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:3b4f482e9161c42c",
            "obj": "PMID:22386944",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:3b4f482e9161c42c",
            "obj": "MONDO:0006848",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:3b4f482e9161c42c",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:3b4f482e9161c42c",
            "obj": "PMID:19859052",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:3b4f482e9161c42c",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:20017836",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:808679",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19859052",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22386944",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:9350678",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "erectile dysfunction (disease)",
        "id": "MONDO:0005362"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "113fbbae-bc04-4be9-a2a7-530e9aeab149",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:22234180",
            "lbl": null
          },
          {
            "id": "PMID:17053524",
            "lbl": null
          },
          {
            "id": "MONDO:0005362",
            "lbl": "erectile dysfunction (disease)"
          },
          {
            "id": "PMID:22072232",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONARCH:158c90f5e681db68",
            "lbl": null
          },
          {
            "id": "PMID:21056655",
            "lbl": null
          },
          {
            "id": "PMID:1838828",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:158c90f5e681db68",
            "obj": "PMID:1838828",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:158c90f5e681db68",
            "obj": "PMID:21056655",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:158c90f5e681db68",
            "obj": "MONDO:0005362",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:158c90f5e681db68",
            "obj": "PMID:17053524",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0005362",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:158c90f5e681db68",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:158c90f5e681db68",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:158c90f5e681db68",
            "obj": "PMID:22234180",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:158c90f5e681db68",
            "obj": "PMID:22072232",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:21056655",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17053524",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:1838828",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22072232",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22234180",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "atypical Werner syndrome",
        "id": "MONDO:0019321"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "96ca6c7d-db07-4fd0-8d61-8c40a7ef696a",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "HP:0040281",
            "lbl": "Very frequent"
          },
          {
            "id": "MONARCH:34755bc83505c24b",
            "lbl": null
          },
          {
            "id": "MONDO:0019321",
            "lbl": "atypical Werner syndrome"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:34755bc83505c24b",
            "obj": "MONDO:0019321",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONDO:0019321",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:34755bc83505c24b",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:34755bc83505c24b",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "hypogonadism",
        "id": "MONDO:0002146"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "2a6c9e63-2ed6-4aea-83bd-419d5786c06c",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONARCH:4dfa4434f4ae925f",
            "lbl": null
          },
          {
            "id": "PMID:18824832",
            "lbl": null
          },
          {
            "id": "PMID:10665337",
            "lbl": null
          },
          {
            "id": "PMID:18821286",
            "lbl": null
          },
          {
            "id": "PMID:15760892",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONDO:0002146",
            "lbl": "hypogonadism"
          },
          {
            "id": "PMID:23933894",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:4dfa4434f4ae925f",
            "obj": "PMID:23933894",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:4dfa4434f4ae925f",
            "obj": "PMID:18824832",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0002146",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:4dfa4434f4ae925f",
            "obj": "MONDO:0002146",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:4dfa4434f4ae925f",
            "obj": "PMID:10665337",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:4dfa4434f4ae925f",
            "obj": "PMID:18821286",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:4dfa4434f4ae925f",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:4dfa4434f4ae925f",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:4dfa4434f4ae925f",
            "obj": "PMID:15760892",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:23933894",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:10665337",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:18821286",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15760892",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:18824832",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "lipoatrophic diabetes",
        "id": "MONDO:0005827"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "37b97dd5-19b3-44a0-960b-c4f4183caac0",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:16459536",
            "lbl": null
          },
          {
            "id": "MONDO:0005827",
            "lbl": "lipoatrophic diabetes"
          },
          {
            "id": "PMID:16236542",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
"""
  def part03: String =
"""
            "id": "MONARCH:651133975262cdf5",
            "lbl": null
          },
          {
            "id": "PMID:15531479",
            "lbl": null
          },
          {
            "id": "PMID:8458533",
            "lbl": null
          },
          {
            "id": "PMID:16320084",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:651133975262cdf5",
            "obj": "MONDO:0005827",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONDO:0005827",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:651133975262cdf5",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:651133975262cdf5",
            "obj": "PMID:16236542",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:651133975262cdf5",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:651133975262cdf5",
            "obj": "PMID:8458533",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:651133975262cdf5",
            "obj": "PMID:15531479",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:651133975262cdf5",
            "obj": "PMID:16320084",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:651133975262cdf5",
            "obj": "PMID:16459536",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:16320084",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:16459536",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:16236542",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:8458533",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15531479",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "hypopituitarism",
        "id": "MONDO:0005152"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "5d2c6224-6e14-4424-993c-766d7dd5a577",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:22137497",
            "lbl": null
          },
          {
            "id": "PMID:7924785",
            "lbl": null
          },
          {
            "id": "PMID:18381581",
            "lbl": null
          },
          {
            "id": "PMID:14572166",
            "lbl": null
          },
          {
            "id": "MONDO:0005152",
            "lbl": "hypopituitarism"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:11701703",
            "lbl": null
          },
          {
            "id": "MONARCH:252515e6be95c451",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:252515e6be95c451",
            "obj": "MONDO:0005152",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:252515e6be95c451",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONDO:0005152",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:252515e6be95c451",
            "obj": "PMID:11701703",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:252515e6be95c451",
            "obj": "PMID:7924785",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:252515e6be95c451",
            "obj": "PMID:22137497",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:252515e6be95c451",
            "obj": "PMID:14572166",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:252515e6be95c451",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:252515e6be95c451",
            "obj": "PMID:18381581",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:14572166",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:7924785",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22137497",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:11701703",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:18381581",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "glucose intolerance",
        "id": "MONDO:0001076"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "83015eed-78f4-4eb6-a396-62a2618720f4",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0001076",
            "lbl": "glucose intolerance"
          },
          {
            "id": "PMID:19887029",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "PMID:18079485",
            "lbl": null
          },
          {
            "id": "PMID:23085227",
            "lbl": null
          },
          {
            "id": "PMID:8000110",
            "lbl": null
          },
          {
            "id": "PMID:22297305",
            "lbl": null
          },
          {
            "id": "MONARCH:1c3f353b48b6f6d6",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:1c3f353b48b6f6d6",
            "obj": "MONDO:0001076",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONDO:0001076",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:1c3f353b48b6f6d6",
            "obj": "PMID:23085227",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1c3f353b48b6f6d6",
            "obj": "PMID:22297305",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1c3f353b48b6f6d6",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:1c3f353b48b6f6d6",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:1c3f353b48b6f6d6",
            "obj": "PMID:19887029",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1c3f353b48b6f6d6",
            "obj": "PMID:18079485",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1c3f353b48b6f6d6",
            "obj": "PMID:8000110",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:18079485",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22297305",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:8000110",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:23085227",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19887029",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "short syndrome",
        "id": "MONDO:0010026"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "c593ec1a-3f67-4461-a8d7-7d6900b19130",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONARCH:57e7d258e8e4b8b9",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "MONDO:0010026",
            "lbl": "short syndrome"
          },
          {
            "id": "ECO:0000501",
            "lbl": "evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0010026",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:57e7d258e8e4b8b9",
            "obj": "MONDO:0010026",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:57e7d258e8e4b8b9",
            "obj": "ECO:0000501",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:57e7d258e8e4b8b9",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "aromatase deficiency",
        "id": "MONDO:0013301"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "2ec773c0-f38d-4cec-badd-9e76cf5044ca",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "MONARCH:e6b9ff25e2dbd00f",
            "lbl": null
          },
          {
            "id": "MONDO:0013301",
            "lbl": "aromatase deficiency"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "HP:0040282",
            "lbl": "Frequent"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0013301",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:e6b9ff25e2dbd00f",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:e6b9ff25e2dbd00f",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:e6b9ff25e2dbd00f",
            "obj": "MONDO:0013301",
            "pred": "OBAN:association_has_subject"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "obesity due to CEP19 deficiency",
        "id": "MONDO:0014309"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "f0d9169b-413c-468f-ac9b-ba335eddcc72",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0014309",
            "lbl": "obesity due to CEP19 deficiency"
          },
          {
            "id": "MONARCH:85654bb1ee7ceb77",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "ECO:0000501",
            "lbl": "evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0014309",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:85654bb1ee7ceb77",
            "obj": "ECO:0000501",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:85654bb1ee7ceb77",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:85654bb1ee7ceb77",
            "obj": "MONDO:0014309",
            "pred": "OBAN:association_has_subject"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "lipodystrophy (disease)",
        "id": "MONDO:0006573"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "8b8ab909-2f43-412c-b58f-a86bbe8e6fa5",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:3440445",
            "lbl": null
          },
          {
            "id": "MONARCH:d511149a5a39b178",
            "lbl": null
          },
          {
            "id": "MONDO:0006573",
            "lbl": "lipodystrophy (disease)"
          },
          {
            "id": "PMID:17084639",
            "lbl": null
          },
          {
            "id": "PMID:7033421",
            "lbl": null
          },
          {
            "id": "PMID:11781404",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:10716495",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:d511149a5a39b178",
            "obj": "PMID:7033421",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:d511149a5a39b178",
            "obj": "PMID:10716495",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0006573",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:d511149a5a39b178",
            "obj": "PMID:3440445",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:d511149a5a39b178",
            "obj": "MONDO:0006573",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:d511149a5a39b178",
            "obj": "PMID:11781404",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:d511149a5a39b178",
            "obj": "PMID:17084639",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:d511149a5a39b178",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:d511149a5a39b178",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:10716495",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:11781404",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17084639",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:3440445",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:7033421",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "progeria",
        "id": "MONDO:0008310"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "fa789bcf-87cf-4b2f-ba12-9768b07186aa",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0008310",
            "lbl": "progeria"
          },
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "MONARCH:2d68f2c93bcc06ff",
            "lbl": null
          },
          {
            "id": "HP:0000877",
            "lbl": "Insulin-resistant diabetes mellitus at puberty"
          },
          {
            "id": "HP:0040283",
            "lbl": "Occasional"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0008310",
            "obj": "HP:0000877",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:2d68f2c93bcc06ff",
            "obj": "MONDO:0008310",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:2d68f2c93bcc06ff",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:2d68f2c93bcc06ff",
            "obj": "HP:0000877",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus at puberty",
        "id": "HP:0000877"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "diabetes mellitus (disease)",
        "id": "MONDO:0005015"
      },
      "relation": {
"""
  def part04: String =
"""
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "7402ea86-6d9e-42ab-8da8-8c09bb597112",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:15895517",
            "lbl": null
          },
          {
            "id": "PMID:20417901",
            "lbl": null
          },
          {
            "id": "MONDO:0005015",
            "lbl": "diabetes mellitus (disease)"
          },
          {
            "id": "PMID:37498",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "PMID:8000110",
            "lbl": null
          },
          {
            "id": "MONARCH:71d7ab77f52d7f6e",
            "lbl": null
          },
          {
            "id": "PMID:15281897",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:71d7ab77f52d7f6e",
            "obj": "PMID:8000110",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:71d7ab77f52d7f6e",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:71d7ab77f52d7f6e",
            "obj": "PMID:15895517",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0005015",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:71d7ab77f52d7f6e",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:71d7ab77f52d7f6e",
            "obj": "PMID:15281897",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:71d7ab77f52d7f6e",
            "obj": "MONDO:0005015",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:71d7ab77f52d7f6e",
            "obj": "PMID:37498",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:71d7ab77f52d7f6e",
            "obj": "PMID:20417901",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:8000110",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15895517",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20417901",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:37498",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15281897",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "hypertension",
        "id": "MONDO:0005044"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "c6df177a-0780-43db-a62b-22343f742386",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONARCH:2a0fb3299d6e7db4",
            "lbl": null
          },
          {
            "id": "PMID:12806595",
            "lbl": null
          },
          {
            "id": "PMID:15258553",
            "lbl": null
          },
          {
            "id": "MONDO:0005044",
            "lbl": "hypertension"
          },
          {
            "id": "PMID:1725004",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:9267147",
            "lbl": null
          },
          {
            "id": "PMID:20479654",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:2a0fb3299d6e7db4",
            "obj": "PMID:20479654",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:2a0fb3299d6e7db4",
            "obj": "MONDO:0005044",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:2a0fb3299d6e7db4",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:2a0fb3299d6e7db4",
            "obj": "PMID:12806595",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:2a0fb3299d6e7db4",
            "obj": "PMID:1725004",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0005044",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:2a0fb3299d6e7db4",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:2a0fb3299d6e7db4",
            "obj": "PMID:15258553",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:2a0fb3299d6e7db4",
            "obj": "PMID:9267147",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:9267147",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20479654",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15258553",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:1725004",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:12806595",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "hypogonadotropic hypogonadism-severe microcephaly-sensorineural hearing loss-dysmorphism syndrome",
        "id": "MONDO:0017406"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "0771c7aa-f379-472b-b345-62b25439f203",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "MONARCH:355fa9e8e2868d2a",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "MONDO:0017406",
            "lbl": "hypogonadotropic hypogonadism-severe microcephaly-sensorineural hearing loss-dysmorphism syndrome"
          },
          {
            "id": "HP:0040282",
            "lbl": "Frequent"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:355fa9e8e2868d2a",
            "obj": "MONDO:0017406",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:355fa9e8e2868d2a",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONDO:0017406",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:355fa9e8e2868d2a",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "neurodegenerative disease",
        "id": "MONDO:0005559"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "a1e8277a-8966-433e-8e5b-979c71b82318",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:19622391",
            "lbl": null
          },
          {
            "id": "MONARCH:4ba64be2d91fe502",
            "lbl": null
          },
          {
            "id": "PMID:20181448",
            "lbl": null
          },
          {
            "id": "PMID:16988486",
            "lbl": null
          },
          {
            "id": "MONDO:0005559",
            "lbl": "neurodegenerative disease"
          },
          {
            "id": "PMID:22411248",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:17897026",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:4ba64be2d91fe502",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:4ba64be2d91fe502",
            "obj": "MONDO:0005559",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:4ba64be2d91fe502",
            "obj": "PMID:17897026",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:4ba64be2d91fe502",
            "obj": "PMID:19622391",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0005559",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:4ba64be2d91fe502",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:4ba64be2d91fe502",
            "obj": "PMID:20181448",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:4ba64be2d91fe502",
            "obj": "PMID:22411248",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:4ba64be2d91fe502",
            "obj": "PMID:16988486",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:17897026",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20181448",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22411248",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:16988486",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19622391",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "acanthosis nigricans-insulin resistance-muscle cramps-acral enlargement syndrome",
        "id": "MONDO:0008696"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "7b0225ab-0f3a-4631-b5b1-3f4f8b33c794",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "MONDO:0008696",
            "lbl": "acanthosis nigricans-insulin resistance-muscle cramps-acral enlargement syndrome"
          },
          {
            "id": "MONARCH:b31abf51065a0b38",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "HP:0040281",
            "lbl": "Very frequent"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0008696",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:b31abf51065a0b38",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:b31abf51065a0b38",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:b31abf51065a0b38",
            "obj": "MONDO:0008696",
            "pred": "OBAN:association_has_subject"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "mandibuloacral dysplasia with type A lipodystrophy",
        "id": "MONDO:0009557"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "441dbf64-4580-4116-9ee3-86b0ba2a19c0",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONARCH:42700a7f1122675e",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "ECO:0000501",
            "lbl": "evidence used in automatic assertion"
          },
          {
            "id": "MONDO:0009557",
            "lbl": "mandibuloacral dysplasia with type A lipodystrophy"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0009557",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:42700a7f1122675e",
            "obj": "ECO:0000501",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:42700a7f1122675e",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:42700a7f1122675e",
            "obj": "MONDO:0009557",
            "pred": "OBAN:association_has_subject"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "obesity due to leptin receptor gene deficiency",
        "id": "MONDO:0013992"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "7af21b44-6b00-442d-865b-ec3a8360f4af",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "MONARCH:2762d5cefadabf15",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "MONDO:0013992",
            "lbl": "obesity due to leptin receptor gene deficiency"
          },
          {
            "id": "HP:0040282",
            "lbl": "Frequent"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0013992",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:2762d5cefadabf15",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:2762d5cefadabf15",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:2762d5cefadabf15",
            "obj": "MONDO:0013992",
            "pred": "OBAN:association_has_subject"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Silver-Russell syndrome",
        "id": "MONDO:0008394"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "66fb26b5-9b5b-4264-b9ee-f898535e9f56",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:22419125",
            "lbl": null
          },
          {
            "id": "MONDO:0008394",
            "lbl": "Silver-Russell syndrome"
          },
          {
            "id": "MONARCH:1aa0c5882c3b56ec",
            "lbl": null
          },
          {
            "id": "HP:0008255",
            "lbl": "Transient neonatal diabetes mellitus"
          },
          {
            "id": "PMID:20738330",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          },
          {
            "id": "PMID:23750647",
            "lbl": null
          },
          {
            "id": "PMID:23335487",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:1aa0c5882c3b56ec",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:1aa0c5882c3b56ec",
            "obj": "PMID:20738330",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1aa0c5882c3b56ec",
            "obj": "MONDO:0008394",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:1aa0c5882c3b56ec",
            "obj": "HP:0008255",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONDO:0008394",
            "obj": "HP:0008255",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:1aa0c5882c3b56ec",
            "obj": "PMID:22419125",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1aa0c5882c3b56ec",
            "obj": "PMID:23335487",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1aa0c5882c3b56ec",
            "obj": "PMID:23750647",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:20738330",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:23335487",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:23750647",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22419125",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
"""
  def part05: String =
"""
        },
        "label": "Transient neonatal diabetes mellitus",
        "id": "HP:0008255"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "drug-induced liver injury",
        "id": "MONDO:0005359"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "abb7d091-8451-40df-bf9e-7066864adf2a",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONARCH:492a0d75f29ae844",
            "lbl": null
          },
          {
            "id": "PMID:15553600",
            "lbl": null
          },
          {
            "id": "PMID:17473493",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:17368274",
            "lbl": null
          },
          {
            "id": "MONDO:0005359",
            "lbl": "drug-induced liver injury"
          },
          {
            "id": "PMID:10929166",
            "lbl": null
          },
          {
            "id": "PMID:14562856",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:492a0d75f29ae844",
            "obj": "PMID:10929166",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0005359",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:492a0d75f29ae844",
            "obj": "MONDO:0005359",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:492a0d75f29ae844",
            "obj": "PMID:17473493",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:492a0d75f29ae844",
            "obj": "PMID:14562856",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:492a0d75f29ae844",
            "obj": "PMID:15553600",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:492a0d75f29ae844",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:492a0d75f29ae844",
            "obj": "PMID:17368274",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:492a0d75f29ae844",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:17473493",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:14562856",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17368274",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15553600",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:10929166",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "familial partial lipodystrophy, KC6bberling type",
        "id": "MONDO:0012072"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "65dc8210-6da0-47da-b99d-fb0a26ddbd5a",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0012072",
            "lbl": "familial partial lipodystrophy, KC6bberling type"
          },
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "HP:0040281",
            "lbl": "Very frequent"
          },
          {
            "id": "MONARCH:832337d3f1173f8f",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0012072",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:832337d3f1173f8f",
            "obj": "MONDO:0012072",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:832337d3f1173f8f",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:832337d3f1173f8f",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Klinefelter's syndrome",
        "id": "MONDO:0006823"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "2de829ab-7478-4376-8031-9be72d34cec3",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:21342256",
            "lbl": null
          },
          {
            "id": "PMID:9747063",
            "lbl": null
          },
          {
            "id": "MONDO:0006823",
            "lbl": "Klinefelter's syndrome"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:10563749",
            "lbl": null
          },
          {
            "id": "PMID:16801584",
            "lbl": null
          },
          {
            "id": "MONARCH:c5824e4c25c8a920",
            "lbl": null
          },
          {
            "id": "PMID:20308053",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0006823",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:c5824e4c25c8a920",
            "obj": "MONDO:0006823",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:c5824e4c25c8a920",
            "obj": "PMID:20308053",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:c5824e4c25c8a920",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:c5824e4c25c8a920",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:c5824e4c25c8a920",
            "obj": "PMID:21342256",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:c5824e4c25c8a920",
            "obj": "PMID:10563749",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:c5824e4c25c8a920",
            "obj": "PMID:16801584",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:c5824e4c25c8a920",
            "obj": "PMID:9747063",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:16801584",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21342256",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20308053",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:10563749",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:9747063",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "familial partial lipodystrophy",
        "id": "MONDO:0020088"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "eeae32bf-2d5d-4d77-a083-4d90d668fb19",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0020088",
            "lbl": "familial partial lipodystrophy"
          },
          {
            "id": "MONARCH:7e9ce2e97846de65",
            "lbl": null
          },
          {
            "id": "PMID:19201734",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:17299075",
            "lbl": null
          },
          {
            "id": "PMID:17936664",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          },
          {
            "id": "PMID:22170723",
            "lbl": null
          },
          {
            "id": "PMID:22559930",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0020088",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:7e9ce2e97846de65",
            "obj": "PMID:17936664",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:7e9ce2e97846de65",
            "obj": "MONDO:0020088",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:7e9ce2e97846de65",
            "obj": "PMID:22170723",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:7e9ce2e97846de65",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:7e9ce2e97846de65",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:7e9ce2e97846de65",
            "obj": "PMID:19201734",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:7e9ce2e97846de65",
            "obj": "PMID:22559930",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:7e9ce2e97846de65",
            "obj": "PMID:17299075",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:17936664",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22170723",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19201734",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22559930",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17299075",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "autosomal semi-dominant severe lipodystrophic laminopathy",
        "id": "MONDO:0017230"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "75891ad7-ac0a-4406-b24d-1e61acc94024",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "HP:0040281",
            "lbl": "Very frequent"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONDO:0017230",
            "lbl": "autosomal semi-dominant severe lipodystrophic laminopathy"
          },
          {
            "id": "MONARCH:d85b357453061451",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:d85b357453061451",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:d85b357453061451",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONDO:0017230",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:d85b357453061451",
            "obj": "MONDO:0017230",
            "pred": "OBAN:association_has_subject"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "cystic fibrosis",
        "id": "MONDO:0009061"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "b3c66b32-ec8a-4401-bcb0-b3c61715ecc5",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:21483232",
            "lbl": null
          },
          {
            "id": "MONDO:0009061",
            "lbl": "cystic fibrosis"
          },
          {
            "id": "PMID:7641765",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:21502328",
            "lbl": null
          },
          {
            "id": "PMID:17418606",
            "lbl": null
          },
          {
            "id": "MONARCH:5a994da75acd60e1",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          },
          {
            "id": "PMID:18035147",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:5a994da75acd60e1",
            "obj": "PMID:18035147",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0009061",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:5a994da75acd60e1",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:5a994da75acd60e1",
            "obj": "MONDO:0009061",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:5a994da75acd60e1",
            "obj": "PMID:7641765",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:5a994da75acd60e1",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:5a994da75acd60e1",
            "obj": "PMID:21502328",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:5a994da75acd60e1",
            "obj": "PMID:21483232",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:5a994da75acd60e1",
            "obj": "PMID:17418606",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:21502328",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21483232",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:7641765",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:18035147",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17418606",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "placental insufficiency",
        "id": "MONDO:0005919"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "ec394c79-c782-427d-964d-15a777f3dd0d",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "MONARCH:1c4d3ffb57a78f23",
            "lbl": null
          },
          {
            "id": "PMID:20053495",
            "lbl": null
          },
          {
            "id": "PMID:17895285",
            "lbl": null
          },
          {
            "id": "PMID:15084713",
            "lbl": null
          },
          {
            "id": "PMID:18339706",
            "lbl": null
          },
          {
            "id": "PMID:17204495",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONDO:0005919",
            "lbl": "placental insufficiency"
          },
          {
            "id": "HP:0040283",
            "lbl": "Occasional"
          },
          {
            "id": "MONARCH:51f4f68dd28e8e0a",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:1c4d3ffb57a78f23",
            "obj": "PMID:17204495",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:51f4f68dd28e8e0a",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:1c4d3ffb57a78f23",
            "obj": "PMID:18339706",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:51f4f68dd28e8e0a",
            "obj": "MONDO:0005919",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:51f4f68dd28e8e0a",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:1c4d3ffb57a78f23",
            "obj": "PMID:17895285",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1c4d3ffb57a78f23",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONDO:0005919",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:1c4d3ffb57a78f23",
            "obj": "PMID:15084713",
            "pred": "dc:source"
"""
  def part06: String =
"""
          },
          {
            "sub": "MONARCH:1c4d3ffb57a78f23",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:1c4d3ffb57a78f23",
            "obj": "MONDO:0005919",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONDO:0005919",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:1c4d3ffb57a78f23",
            "obj": "PMID:20053495",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:17895285",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15084713",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17204495",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20053495",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:18339706",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "chronic hepatitis C",
        "id": "MONDO:0005354"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "d75e590b-2bae-4587-ab5d-20a1e933dfa5",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:19072356",
            "lbl": null
          },
          {
            "id": "PMID:19381127",
            "lbl": null
          },
          {
            "id": "MONDO:0005354",
            "lbl": "chronic hepatitis C"
          },
          {
            "id": "MONARCH:568c46200a279274",
            "lbl": null
          },
          {
            "id": "PMID:19291180",
            "lbl": null
          },
          {
            "id": "PMID:15765399",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:22326764",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:568c46200a279274",
            "obj": "PMID:19072356",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0005354",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:568c46200a279274",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:568c46200a279274",
            "obj": "PMID:19291180",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:568c46200a279274",
            "obj": "PMID:15765399",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:568c46200a279274",
            "obj": "PMID:19381127",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:568c46200a279274",
            "obj": "MONDO:0005354",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:568c46200a279274",
            "obj": "PMID:22326764",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:568c46200a279274",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:15765399",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19072356",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19291180",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22326764",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19381127",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "liver cancer",
        "id": "MONDO:0002691"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "c6314a6e-303c-4e0a-a664-a7bf133496b4",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0002691",
            "lbl": "liver cancer"
          },
          {
            "id": "PMID:14500580",
            "lbl": null
          },
          {
            "id": "PMID:18772845",
            "lbl": null
          },
          {
            "id": "PMID:19637730",
            "lbl": null
          },
          {
            "id": "PMID:21569630",
            "lbl": null
          },
          {
            "id": "PMID:14685853",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONARCH:8d0661ccf2dfe173",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:8d0661ccf2dfe173",
            "obj": "PMID:14685853",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:8d0661ccf2dfe173",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:8d0661ccf2dfe173",
            "obj": "PMID:14500580",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0002691",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:8d0661ccf2dfe173",
            "obj": "PMID:18772845",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:8d0661ccf2dfe173",
            "obj": "MONDO:0002691",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:8d0661ccf2dfe173",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:8d0661ccf2dfe173",
            "obj": "PMID:21569630",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:8d0661ccf2dfe173",
            "obj": "PMID:19637730",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:19637730",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:14685853",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21569630",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:14500580",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:18772845",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "hyperaldosteronism",
        "id": "MONDO:0003009"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "5afc5dbf-8728-4dfe-85b1-01038beb54a4",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:18923367",
            "lbl": null
          },
          {
            "id": "PMID:17143190",
            "lbl": null
          },
          {
            "id": "MONDO:0003009",
            "lbl": "hyperaldosteronism"
          },
          {
            "id": "PMID:19460644",
            "lbl": null
          },
          {
            "id": "PMID:19099949",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONARCH:753e0ed29d73e98f",
            "lbl": null
          },
          {
            "id": "PMID:22116746",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:753e0ed29d73e98f",
            "obj": "PMID:19099949",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:753e0ed29d73e98f",
            "obj": "PMID:17143190",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:753e0ed29d73e98f",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:753e0ed29d73e98f",
            "obj": "PMID:18923367",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:753e0ed29d73e98f",
            "obj": "PMID:22116746",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:753e0ed29d73e98f",
            "obj": "MONDO:0003009",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:753e0ed29d73e98f",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:753e0ed29d73e98f",
            "obj": "PMID:19460644",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0003009",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:19460644",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22116746",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19099949",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17143190",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:18923367",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "beta thalassemia",
        "id": "MONDO:0019402"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "1c401b1d-ce66-4194-ade1-78c5085b33de",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:7885270",
            "lbl": null
          },
          {
            "id": "PMID:17899188",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONARCH:aef8df1c2d8fe8ac",
            "lbl": null
          },
          {
            "id": "PMID:8936961",
            "lbl": null
          },
          {
            "id": "PMID:16800840",
            "lbl": null
          },
          {
            "id": "MONDO:0019402",
            "lbl": "beta thalassemia"
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          },
          {
            "id": "PMID:16822284",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:aef8df1c2d8fe8ac",
            "obj": "PMID:16822284",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:aef8df1c2d8fe8ac",
            "obj": "PMID:7885270",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:aef8df1c2d8fe8ac",
            "obj": "PMID:17899188",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:aef8df1c2d8fe8ac",
            "obj": "MONDO:0019402",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:aef8df1c2d8fe8ac",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONDO:0019402",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:aef8df1c2d8fe8ac",
            "obj": "PMID:8936961",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:aef8df1c2d8fe8ac",
            "obj": "PMID:16800840",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:aef8df1c2d8fe8ac",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:16822284",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:8936961",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17899188",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:16800840",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:7885270",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "lipodystrophy due to peptidic growth factors deficiency",
        "id": "MONDO:0009312"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "7ec64596-1504-4de6-a0e2-64eda0f5fd84",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0009312",
            "lbl": "lipodystrophy due to peptidic growth factors deficiency"
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "MONARCH:249214dd064167ae",
            "lbl": null
          },
          {
            "id": "ECO:0000501",
            "lbl": "evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:249214dd064167ae",
            "obj": "ECO:0000501",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:249214dd064167ae",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:249214dd064167ae",
            "obj": "MONDO:0009312",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONDO:0009312",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "acquired generalized lipodystrophy",
        "id": "MONDO:0019193"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "296f45dc-ab0a-48a9-8a61-927e4f1f947f",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "MONDO:0019193",
            "lbl": "acquired generalized lipodystrophy"
          },
          {
            "id": "MONARCH:130f48df09cbdc83",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "HP:0040282",
            "lbl": "Frequent"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0019193",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:130f48df09cbdc83",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:130f48df09cbdc83",
            "obj": "MONDO:0019193",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:130f48df09cbdc83",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Wolcott-Rallison syndrome",
        "id": "MONDO:0009192"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "d6feebbd-0078-471d-9bff-8d09751302b8",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "MONDO:0009192",
            "lbl": "Wolcott-Rallison syndrome"
"""
  def part07: String =
"""
          },
          {
            "id": "MONARCH:1631e83f88478209",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:1631e83f88478209",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:1631e83f88478209",
            "obj": "MONDO:0009192",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:1631e83f88478209",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONDO:0009192",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "cirrhosis of liver",
        "id": "MONDO:0005155"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "e239d9ca-18a9-4c84-aae2-836cbcca322f",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:17013519",
            "lbl": null
          },
          {
            "id": "PMID:19443968",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "PMID:11580152",
            "lbl": null
          },
          {
            "id": "PMID:16478779",
            "lbl": null
          },
          {
            "id": "MONARCH:7f21630c142ed13b",
            "lbl": null
          },
          {
            "id": "PMID:8119686",
            "lbl": null
          },
          {
            "id": "MONDO:0005155",
            "lbl": "cirrhosis of liver"
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:7f21630c142ed13b",
            "obj": "MONDO:0005155",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:7f21630c142ed13b",
            "obj": "PMID:8119686",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:7f21630c142ed13b",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONDO:0005155",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:7f21630c142ed13b",
            "obj": "PMID:11580152",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:7f21630c142ed13b",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:7f21630c142ed13b",
            "obj": "PMID:17013519",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:7f21630c142ed13b",
            "obj": "PMID:19443968",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:7f21630c142ed13b",
            "obj": "PMID:16478779",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:11580152",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:8119686",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:16478779",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19443968",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17013519",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "progeria-short stature-pigmented nevi syndrome",
        "id": "MONDO:0008311"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "b0553705-3c14-4b6e-a0e9-17dc51f6309b",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "MONARCH:c4793d1f5ee114ba",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "HP:0040281",
            "lbl": "Very frequent"
          },
          {
            "id": "MONDO:0008311",
            "lbl": "progeria-short stature-pigmented nevi syndrome"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:c4793d1f5ee114ba",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONDO:0008311",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:c4793d1f5ee114ba",
            "obj": "MONDO:0008311",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:c4793d1f5ee114ba",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "progeria",
        "id": "MONDO:0008310"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "552a3199-526b-47a6-9215-c2d6504cef7a",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0008310",
            "lbl": "progeria"
          },
          {
            "id": "MONARCH:3b46a25d2cdb2e3c",
            "lbl": null
          },
          {
            "id": "PMID:3440445",
            "lbl": null
          },
          {
            "id": "PMID:17523150",
            "lbl": null
          },
          {
            "id": "PMID:1646740",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:293690",
            "lbl": null
          },
          {
            "id": "PMID:21632068",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:3b46a25d2cdb2e3c",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:3b46a25d2cdb2e3c",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:3b46a25d2cdb2e3c",
            "obj": "MONDO:0008310",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:3b46a25d2cdb2e3c",
            "obj": "PMID:17523150",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:3b46a25d2cdb2e3c",
            "obj": "PMID:293690",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0008310",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:3b46a25d2cdb2e3c",
            "obj": "PMID:21632068",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:3b46a25d2cdb2e3c",
            "obj": "PMID:1646740",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:3b46a25d2cdb2e3c",
            "obj": "PMID:3440445",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:1646740",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17523150",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:293690",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:3440445",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21632068",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Prader-Willi syndrome",
        "id": "MONDO:0008300"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "9f19b516-a7da-4d55-b469-f3b401c511e1",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:15476445",
            "lbl": null
          },
          {
            "id": "MONARCH:a816cfd553d922a9",
            "lbl": null
          },
          {
            "id": "PMID:10665337",
            "lbl": null
          },
          {
            "id": "PMID:16026111",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:14700552",
            "lbl": null
          },
          {
            "id": "PMID:15687345",
            "lbl": null
          },
          {
            "id": "MONDO:0008300",
            "lbl": "Prader-Willi syndrome"
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:a816cfd553d922a9",
            "obj": "PMID:16026111",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a816cfd553d922a9",
            "obj": "PMID:10665337",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a816cfd553d922a9",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:a816cfd553d922a9",
            "obj": "MONDO:0008300",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONDO:0008300",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:a816cfd553d922a9",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:a816cfd553d922a9",
            "obj": "PMID:14700552",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a816cfd553d922a9",
            "obj": "PMID:15687345",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a816cfd553d922a9",
            "obj": "PMID:15476445",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:16026111",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15476445",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:10665337",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15687345",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:14700552",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "hepatocellular carcinoma",
        "id": "MONDO:0007256"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "59427f6a-43c7-4573-9b7d-a495935cf08c",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:14500580",
            "lbl": null
          },
          {
            "id": "PMID:9015760",
            "lbl": null
          },
          {
            "id": "MONARCH:bfe8f163254ad7f7",
            "lbl": null
          },
          {
            "id": "MONDO:0007256",
            "lbl": "hepatocellular carcinoma"
          },
          {
            "id": "PMID:19637730",
            "lbl": null
          },
          {
            "id": "PMID:1656753",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:9312143",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:bfe8f163254ad7f7",
            "obj": "MONDO:0007256",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONDO:0007256",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:bfe8f163254ad7f7",
            "obj": "PMID:19637730",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:bfe8f163254ad7f7",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:bfe8f163254ad7f7",
            "obj": "PMID:9312143",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:bfe8f163254ad7f7",
            "obj": "PMID:14500580",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:bfe8f163254ad7f7",
            "obj": "PMID:9015760",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:bfe8f163254ad7f7",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:bfe8f163254ad7f7",
            "obj": "PMID:1656753",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:19637730",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:9015760",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:1656753",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:9312143",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:14500580",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Beckwith-Wiedemann syndrome",
        "id": "MONDO:0007534"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "5a476ff0-77a7-490d-9220-b79df00294b4",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONARCH:292db7d359faac3d",
            "lbl": null
          },
          {
            "id": "PMID:17413842",
            "lbl": null
          },
          {
            "id": "PMID:22419125",
            "lbl": null
          },
          {
            "id": "PMID:19407494",
            "lbl": null
          },
          {
            "id": "MONDO:0007534",
            "lbl": "Beckwith-Wiedemann syndrome"
          },
          {
            "id": "HP:0008255",
            "lbl": "Transient neonatal diabetes mellitus"
          },
          {
            "id": "PMID:15888726",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          },
          {
            "id": "PMID:23335487",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:292db7d359faac3d",
            "obj": "MONDO:0007534",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:292db7d359faac3d",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:292db7d359faac3d",
            "obj": "PMID:19407494",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:292db7d359faac3d",
            "obj": "PMID:23335487",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0007534",
            "obj": "HP:0008255",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:292db7d359faac3d",
            "obj": "PMID:22419125",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:292db7d359faac3d",
            "obj": "PMID:15888726",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:292db7d359faac3d",
            "obj": "HP:0008255",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:292db7d359faac3d",
            "obj": "PMID:17413842",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:23335487",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15888726",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17413842",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22419125",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19407494",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
"""
  def part08: String =
"""
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Transient neonatal diabetes mellitus",
        "id": "HP:0008255"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "diabetes mellitus, transient neonatal, 2",
        "id": "MONDO:0012480"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "474dfe02-d7f6-4f7c-8f1d-3566d7dd7990",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONARCH:0f325a677e8055c3",
            "lbl": null
          },
          {
            "id": "PMID:16885549",
            "lbl": null
          },
          {
            "id": "HP:0008255",
            "lbl": "Transient neonatal diabetes mellitus"
          },
          {
            "id": "ECO:0000269",
            "lbl": "experimental evidence used in manual assertion"
          },
          {
            "id": "HP:0003623",
            "lbl": "Neonatal onset"
          },
          {
            "id": "MONDO:0012480",
            "lbl": "diabetes mellitus, transient neonatal, 2"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:0f325a677e8055c3",
            "obj": "MONDO:0012480",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:0f325a677e8055c3",
            "obj": "ECO:0000269",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:0f325a677e8055c3",
            "obj": "PMID:16885549",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0012480",
            "obj": "HP:0008255",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:0f325a677e8055c3",
            "obj": "HP:0008255",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:16885549",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Transient neonatal diabetes mellitus",
        "id": "HP:0008255"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "obstructive sleep apnea (disease)",
        "id": "MONDO:0007147"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "b9c17f47-635d-4b40-aa41-cc086c03ff68",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:15865863",
            "lbl": null
          },
          {
            "id": "PMID:19003725",
            "lbl": null
          },
          {
            "id": "MONDO:0007147",
            "lbl": "obstructive sleep apnea (disease)"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:17382111",
            "lbl": null
          },
          {
            "id": "MONARCH:64ef0dc47aa811e8",
            "lbl": null
          },
          {
            "id": "PMID:19961024",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          },
          {
            "id": "PMID:18276939",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:64ef0dc47aa811e8",
            "obj": "MONDO:0007147",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:64ef0dc47aa811e8",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:64ef0dc47aa811e8",
            "obj": "PMID:19961024",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:64ef0dc47aa811e8",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:64ef0dc47aa811e8",
            "obj": "PMID:18276939",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:64ef0dc47aa811e8",
            "obj": "PMID:15865863",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:64ef0dc47aa811e8",
            "obj": "PMID:17382111",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:64ef0dc47aa811e8",
            "obj": "PMID:19003725",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0007147",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:19961024",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:18276939",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17382111",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15865863",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19003725",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "coronary restenosis",
        "id": "MONDO:0005355"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "72b3dd1c-5c83-46a8-8159-5d87af406554",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONARCH:1d16c1dfbac44eed",
            "lbl": null
          },
          {
            "id": "PMID:17496497",
            "lbl": null
          },
          {
            "id": "PMID:20807190",
            "lbl": null
          },
          {
            "id": "MONDO:0005355",
            "lbl": "coronary restenosis"
          },
          {
            "id": "PMID:15165912",
            "lbl": null
          },
          {
            "id": "PMID:17476040",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:16948449",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0005355",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:1d16c1dfbac44eed",
            "obj": "MONDO:0005355",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:1d16c1dfbac44eed",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:1d16c1dfbac44eed",
            "obj": "PMID:16948449",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1d16c1dfbac44eed",
            "obj": "PMID:17476040",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1d16c1dfbac44eed",
            "obj": "PMID:17496497",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1d16c1dfbac44eed",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:1d16c1dfbac44eed",
            "obj": "PMID:15165912",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1d16c1dfbac44eed",
            "obj": "PMID:20807190",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:16948449",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17476040",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20807190",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17496497",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15165912",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Laron syndrome",
        "id": "MONDO:0009877"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "8fa0201a-97ea-49e1-aa15-0b5919d27faf",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:15621211",
            "lbl": null
          },
          {
            "id": "PMID:20359431",
            "lbl": null
          },
          {
            "id": "PMID:21968387",
            "lbl": null
          },
          {
            "id": "PMID:15231299",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONDO:0009877",
            "lbl": "Laron syndrome"
          },
          {
            "id": "MONARCH:8e3f00f556e26522",
            "lbl": null
          },
          {
            "id": "PMID:16817829",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:8e3f00f556e26522",
            "obj": "PMID:21968387",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:8e3f00f556e26522",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:8e3f00f556e26522",
            "obj": "PMID:15231299",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0009877",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:8e3f00f556e26522",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:8e3f00f556e26522",
            "obj": "PMID:15621211",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:8e3f00f556e26522",
            "obj": "PMID:16817829",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:8e3f00f556e26522",
            "obj": "PMID:20359431",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:8e3f00f556e26522",
            "obj": "MONDO:0009877",
            "pred": "OBAN:association_has_subject"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:21968387",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20359431",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:16817829",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15231299",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15621211",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "cirrhosis of liver",
        "id": "MONDO:0005155"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "3e0c7288-56ca-48d1-94c9-87b0d902c0da",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:3894876",
            "lbl": null
          },
          {
            "id": "PMID:1656753",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:15645407",
            "lbl": null
          },
          {
            "id": "PMID:22922994",
            "lbl": null
          },
          {
            "id": "MONDO:0005155",
            "lbl": "cirrhosis of liver"
          },
          {
            "id": "MONARCH:ffa19f1706d1ef00",
            "lbl": null
          },
          {
            "id": "PMID:1874488",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0005155",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:ffa19f1706d1ef00",
            "obj": "PMID:3894876",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ffa19f1706d1ef00",
            "obj": "MONDO:0005155",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:ffa19f1706d1ef00",
            "obj": "PMID:15645407",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ffa19f1706d1ef00",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:ffa19f1706d1ef00",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:ffa19f1706d1ef00",
            "obj": "PMID:1656753",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ffa19f1706d1ef00",
            "obj": "PMID:1874488",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ffa19f1706d1ef00",
            "obj": "PMID:22922994",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:15645407",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22922994",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:1656753",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:3894876",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:1874488",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "gestational diabetes",
        "id": "MONDO:0005406"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "873cc028-d757-4b6d-a5e7-2b05ef810c45",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:11703438",
            "lbl": null
          },
          {
            "id": "MONARCH:ce9ace737b62087e",
            "lbl": null
          },
          {
            "id": "MONDO:0005406",
            "lbl": "gestational diabetes"
          },
          {
            "id": "PMID:17454170",
            "lbl": null
          },
          {
            "id": "PMID:24053363",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "PMID:20530934",
            "lbl": null
          },
          {
            "id": "PMID:1748241",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:ce9ace737b62087e",
            "obj": "PMID:11703438",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ce9ace737b62087e",
            "obj": "MONDO:0005406",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:ce9ace737b62087e",
            "obj": "PMID:20530934",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ce9ace737b62087e",
            "obj": "PMID:24053363",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0005406",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:ce9ace737b62087e",
            "obj": "PMID:17454170",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ce9ace737b62087e",
            "obj": "PMID:1748241",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ce9ace737b62087e",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:ce9ace737b62087e",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:1748241",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:24053363",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17454170",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:11703438",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20530934",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
"""
  def part09: String =
"""
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Cushing syndrome",
        "id": "MONDO:0018912"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "ed14d861-6804-4b83-baa6-e8ec057ded28",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:3525245",
            "lbl": null
          },
          {
            "id": "PMID:1769133",
            "lbl": null
          },
          {
            "id": "PMID:17315528",
            "lbl": null
          },
          {
            "id": "PMID:15009001",
            "lbl": null
          },
          {
            "id": "PMID:15455200",
            "lbl": null
          },
          {
            "id": "MONDO:0018912",
            "lbl": "Cushing syndrome"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONARCH:e2aa5519af3a1fbb",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:e2aa5519af3a1fbb",
            "obj": "PMID:3525245",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:e2aa5519af3a1fbb",
            "obj": "PMID:1769133",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:e2aa5519af3a1fbb",
            "obj": "PMID:17315528",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:e2aa5519af3a1fbb",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:e2aa5519af3a1fbb",
            "obj": "PMID:15009001",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:e2aa5519af3a1fbb",
            "obj": "MONDO:0018912",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:e2aa5519af3a1fbb",
            "obj": "PMID:15455200",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0018912",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:e2aa5519af3a1fbb",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:17315528",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:3525245",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15009001",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:1769133",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15455200",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "psoriatic arthritis",
        "id": "MONDO:0011849"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "338cbb1f-ae0c-4171-96ff-bb8d88d884c4",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:18400833",
            "lbl": null
          },
          {
            "id": "PMID:18273720",
            "lbl": null
          },
          {
            "id": "MONDO:0011849",
            "lbl": "psoriatic arthritis"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:23406817",
            "lbl": null
          },
          {
            "id": "MONARCH:0857944af773af7f",
            "lbl": null
          },
          {
            "id": "PMID:21737374",
            "lbl": null
          },
          {
            "id": "PMID:19222518",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0011849",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:0857944af773af7f",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:0857944af773af7f",
            "obj": "PMID:23406817",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:0857944af773af7f",
            "obj": "PMID:19222518",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:0857944af773af7f",
            "obj": "MONDO:0011849",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:0857944af773af7f",
            "obj": "PMID:18400833",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:0857944af773af7f",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:0857944af773af7f",
            "obj": "PMID:18273720",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:0857944af773af7f",
            "obj": "PMID:21737374",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:18273720",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:18400833",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19222518",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:23406817",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21737374",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "prediabetes syndrome",
        "id": "MONDO:0006920"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "0a10307b-6ab7-490d-b350-d9791ae82c3e",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:20953067",
            "lbl": null
          },
          {
            "id": "PMID:18036163",
            "lbl": null
          },
          {
            "id": "MONARCH:160810815a5b9f7b",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "PMID:12880690",
            "lbl": null
          },
          {
            "id": "PMID:18245568",
            "lbl": null
          },
          {
            "id": "MONDO:0006920",
            "lbl": "prediabetes syndrome"
          },
          {
            "id": "PMID:21677040",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:160810815a5b9f7b",
            "obj": "PMID:21677040",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:160810815a5b9f7b",
            "obj": "PMID:20953067",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:160810815a5b9f7b",
            "obj": "MONDO:0006920",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONDO:0006920",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:160810815a5b9f7b",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:160810815a5b9f7b",
            "obj": "PMID:18245568",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:160810815a5b9f7b",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:160810815a5b9f7b",
            "obj": "PMID:12880690",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:160810815a5b9f7b",
            "obj": "PMID:18036163",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:18245568",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:18036163",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:12880690",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21677040",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20953067",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "congenital generalized lipodystrophy type 3",
        "id": "MONDO:0012923"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "a900b25e-f493-4b82-955c-2aa576e259b6",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:18211975",
            "lbl": null
          },
          {
            "id": "MONDO:0012923",
            "lbl": "congenital generalized lipodystrophy type 3"
          },
          {
            "id": "ECO:0000269",
            "lbl": "experimental evidence used in manual assertion"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONARCH:98c97956840201fe",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:98c97956840201fe",
            "obj": "MONDO:0012923",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:98c97956840201fe",
            "obj": "PMID:18211975",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:98c97956840201fe",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:98c97956840201fe",
            "obj": "ECO:0000269",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONDO:0012923",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:18211975",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "colorectal cancer",
        "id": "MONDO:0005575"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "907cffd1-eb3a-40e6-a2c1-44acda57cc42",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:16288122",
            "lbl": null
          },
          {
            "id": "PMID:19064544",
            "lbl": null
          },
          {
            "id": "PMID:19050674",
            "lbl": null
          },
          {
            "id": "MONDO:0005575",
            "lbl": "colorectal cancer"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:12540503",
            "lbl": null
          },
          {
            "id": "MONARCH:ad1526a23bcae3e2",
            "lbl": null
          },
          {
            "id": "PMID:22431719",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:ad1526a23bcae3e2",
            "obj": "PMID:19064544",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ad1526a23bcae3e2",
            "obj": "PMID:19050674",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ad1526a23bcae3e2",
            "obj": "PMID:22431719",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ad1526a23bcae3e2",
            "obj": "PMID:12540503",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ad1526a23bcae3e2",
            "obj": "MONDO:0005575",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:ad1526a23bcae3e2",
            "obj": "PMID:16288122",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0005575",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:ad1526a23bcae3e2",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:ad1526a23bcae3e2",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:19064544",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22431719",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:16288122",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19050674",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:12540503",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "diabetic retinopathy",
        "id": "MONDO:0005266"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "84859b6e-76cd-4151-8efa-d7db8ce0edeb",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:15505002",
            "lbl": null
          },
          {
            "id": "PMID:12905764",
            "lbl": null
          },
          {
            "id": "MONDO:0005266",
            "lbl": "diabetic retinopathy"
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "PMID:23197686",
            "lbl": null
          },
          {
            "id": "PMID:20233518",
            "lbl": null
          },
          {
            "id": "MONARCH:b1d0236c65fb17bc",
            "lbl": null
          },
          {
            "id": "PMID:22401335",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:b1d0236c65fb17bc",
            "obj": "PMID:15505002",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:b1d0236c65fb17bc",
            "obj": "MONDO:0005266",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:b1d0236c65fb17bc",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:b1d0236c65fb17bc",
            "obj": "PMID:22401335",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:b1d0236c65fb17bc",
            "obj": "PMID:23197686",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:b1d0236c65fb17bc",
            "obj": "PMID:12905764",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:b1d0236c65fb17bc",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONDO:0005266",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:b1d0236c65fb17bc",
            "obj": "PMID:20233518",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:15505002",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20233518",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22401335",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:23197686",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:12905764",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
"""
  def part10: String =
"""
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Whipple disease",
        "id": "MONDO:0018099"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "40e2d8c2-bf7e-45f0-9e87-125a2d66c153",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "HP:0040283",
            "lbl": "Occasional"
          },
          {
            "id": "MONDO:0018099",
            "lbl": "Whipple disease"
          },
          {
            "id": "MONARCH:711cfeb808a556a5",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:711cfeb808a556a5",
            "obj": "MONDO:0018099",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONDO:0018099",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:711cfeb808a556a5",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:711cfeb808a556a5",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "sarcopenia",
        "id": "MONDO:0006516"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "38722bf2-0098-41be-b4ed-3dcc7cb3d0d3",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:21529326",
            "lbl": null
          },
          {
            "id": "MONDO:0006516",
            "lbl": "sarcopenia"
          },
          {
            "id": "MONARCH:1ff76aa7fd659027",
            "lbl": null
          },
          {
            "id": "PMID:22866000",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:22572647",
            "lbl": null
          },
          {
            "id": "PMID:20554280",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          },
          {
            "id": "PMID:19657556",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:1ff76aa7fd659027",
            "obj": "PMID:22572647",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1ff76aa7fd659027",
            "obj": "PMID:20554280",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1ff76aa7fd659027",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:1ff76aa7fd659027",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:1ff76aa7fd659027",
            "obj": "MONDO:0006516",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:1ff76aa7fd659027",
            "obj": "PMID:22866000",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1ff76aa7fd659027",
            "obj": "PMID:19657556",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1ff76aa7fd659027",
            "obj": "PMID:21529326",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0006516",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:20554280",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22866000",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22572647",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19657556",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21529326",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "vasculitis",
        "id": "MONDO:0018882"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "9a0dc699-d656-4a4d-9e5a-29a4a869e9be",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:21514279",
            "lbl": null
          },
          {
            "id": "PMID:22919404",
            "lbl": null
          },
          {
            "id": "MONDO:0018882",
            "lbl": "vasculitis"
          },
          {
            "id": "MONARCH:ae3c6c1dc0a85697",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:18083792",
            "lbl": null
          },
          {
            "id": "PMID:18054023",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          },
          {
            "id": "PMID:17560580",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:ae3c6c1dc0a85697",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:ae3c6c1dc0a85697",
            "obj": "MONDO:0018882",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:ae3c6c1dc0a85697",
            "obj": "PMID:22919404",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ae3c6c1dc0a85697",
            "obj": "PMID:18083792",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ae3c6c1dc0a85697",
            "obj": "PMID:21514279",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ae3c6c1dc0a85697",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:ae3c6c1dc0a85697",
            "obj": "PMID:17560580",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0018882",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:ae3c6c1dc0a85697",
            "obj": "PMID:18054023",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:18054023",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22919404",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:18083792",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17560580",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21514279",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Donohue syndrome",
        "id": "MONDO:0009517"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "e218da8f-b51a-4624-8dc3-b31afd1929cb",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0009517",
            "lbl": "Donohue syndrome"
          },
          {
            "id": "PMID:23347304",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONARCH:d7308a1cc68c5768",
            "lbl": null
          },
          {
            "id": "PMID:21869538",
            "lbl": null
          },
          {
            "id": "PMID:23367497",
            "lbl": null
          },
          {
            "id": "PMID:20155514",
            "lbl": null
          },
          {
            "id": "PMID:22563226",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:d7308a1cc68c5768",
            "obj": "PMID:23347304",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:d7308a1cc68c5768",
            "obj": "MONDO:0009517",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:d7308a1cc68c5768",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONDO:0009517",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:d7308a1cc68c5768",
            "obj": "PMID:20155514",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:d7308a1cc68c5768",
            "obj": "PMID:23367497",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:d7308a1cc68c5768",
            "obj": "PMID:22563226",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:d7308a1cc68c5768",
            "obj": "PMID:21869538",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:d7308a1cc68c5768",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:23347304",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20155514",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22563226",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21869538",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:23367497",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "calcinosis",
        "id": "MONDO:0002123"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "dd84b4d5-d94f-4820-9000-6409ffd227c9",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:21219421",
            "lbl": null
          },
          {
            "id": "PMID:18344805",
            "lbl": null
          },
          {
            "id": "MONARCH:c8c3a12b535ef816",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:3407011",
            "lbl": null
          },
          {
            "id": "MONDO:0002123",
            "lbl": "calcinosis"
          },
          {
            "id": "PMID:16884397",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          },
          {
            "id": "PMID:17606264",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:c8c3a12b535ef816",
            "obj": "PMID:16884397",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:c8c3a12b535ef816",
            "obj": "PMID:21219421",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:c8c3a12b535ef816",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:c8c3a12b535ef816",
            "obj": "PMID:3407011",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:c8c3a12b535ef816",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:c8c3a12b535ef816",
            "obj": "PMID:18344805",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:c8c3a12b535ef816",
            "obj": "PMID:17606264",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:c8c3a12b535ef816",
            "obj": "MONDO:0002123",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONDO:0002123",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:17606264",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:16884397",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21219421",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:3407011",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:18344805",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "congenital adrenal hyperplasia due to 3-beta-hydroxysteroid dehydrogenase deficiency",
        "id": "MONDO:0008727"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "cbe9e18b-25c4-40c8-9ecb-27774f84ac7b",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "HP:0040282",
            "lbl": "Frequent"
          },
          {
            "id": "MONDO:0008727",
            "lbl": "congenital adrenal hyperplasia due to 3-beta-hydroxysteroid dehydrogenase deficiency"
          },
          {
            "id": "MONARCH:a64bdb61272d2151",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0008727",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:a64bdb61272d2151",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:a64bdb61272d2151",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:a64bdb61272d2151",
            "obj": "MONDO:0008727",
            "pred": "OBAN:association_has_subject"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "paternal uniparental disomy of chromosome 6",
        "id": "MONDO:0019921"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "763364d1-1587-4966-9320-0a052fc1876b",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "MONARCH:51c39c9e28a6d1e2",
            "lbl": null
          },
          {
            "id": "MONDO:0019921",
            "lbl": "paternal uniparental disomy of chromosome 6"
          },
          {
            "id": "HP:0040281",
            "lbl": "Very frequent"
          },
          {
            "id": "HP:0000857",
            "lbl": "Neonatal insulin-dependent diabetes mellitus"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:51c39c9e28a6d1e2",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:51c39c9e28a6d1e2",
            "obj": "HP:0000857",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:51c39c9e28a6d1e2",
            "obj": "MONDO:0019921",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONDO:0019921",
            "obj": "HP:0000857",
            "pred": "RO:0002200"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Neonatal insulin-dependent diabetes mellitus",
        "id": "HP:0000857"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "primary lipodystrophy",
        "id": "MONDO:0019599"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "293d6187-ccdb-47cd-b42c-708cb3d58c92",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "MONDO:0019599",
            "lbl": "primary lipodystrophy"
          },
          {
            "id": "HP:0040281",
            "lbl": "Very frequent"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
"""
  def part11: String =
"""
          {
            "id": "MONARCH:2246f03666a7e70e",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0019599",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:2246f03666a7e70e",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:2246f03666a7e70e",
            "obj": "MONDO:0019599",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:2246f03666a7e70e",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "intermediate coronary syndrome",
        "id": "MONDO:0006805"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "6973242d-e4a5-479a-8d72-7bb22b9914fb",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:16814296",
            "lbl": null
          },
          {
            "id": "PMID:17543176",
            "lbl": null
          },
          {
            "id": "PMID:17293058",
            "lbl": null
          },
          {
            "id": "PMID:10841236",
            "lbl": null
          },
          {
            "id": "MONARCH:64f96346baab49de",
            "lbl": null
          },
          {
            "id": "PMID:14557360",
            "lbl": null
          },
          {
            "id": "MONDO:0006805",
            "lbl": "intermediate coronary syndrome"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:64f96346baab49de",
            "obj": "PMID:14557360",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:64f96346baab49de",
            "obj": "PMID:10841236",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:64f96346baab49de",
            "obj": "PMID:16814296",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:64f96346baab49de",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONDO:0006805",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:64f96346baab49de",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:64f96346baab49de",
            "obj": "MONDO:0006805",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:64f96346baab49de",
            "obj": "PMID:17293058",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:64f96346baab49de",
            "obj": "PMID:17543176",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:10841236",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:16814296",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17543176",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:14557360",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17293058",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "acanthosis nigricans-insulin resistance-muscle cramps-acral enlargement syndrome",
        "id": "MONDO:0008696"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "b9b01842-0d3a-4e87-acbe-29b53d301f74",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0008696",
            "lbl": "acanthosis nigricans-insulin resistance-muscle cramps-acral enlargement syndrome"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "ECO:0000501",
            "lbl": "evidence used in automatic assertion"
          },
          {
            "id": "MONARCH:b1d73f268330d42e",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:b1d73f268330d42e",
            "obj": "ECO:0000501",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONDO:0008696",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:b1d73f268330d42e",
            "obj": "MONDO:0008696",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:b1d73f268330d42e",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "adiposis dolorosa",
        "id": "MONDO:0007070"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "73a88265-0782-47ee-8a20-40b5a4ea6507",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:1342834",
            "lbl": null
          },
          {
            "id": "PMID:9627156",
            "lbl": null
          },
          {
            "id": "MONARCH:205cc7792eb74038",
            "lbl": null
          },
          {
            "id": "MONDO:0007070",
            "lbl": "adiposis dolorosa"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          },
          {
            "id": "PMID:17504714",
            "lbl": null
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:205cc7792eb74038",
            "obj": "MONDO:0007070",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:205cc7792eb74038",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:205cc7792eb74038",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:205cc7792eb74038",
            "obj": "PMID:17504714",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:205cc7792eb74038",
            "obj": "PMID:9627156",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0007070",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:205cc7792eb74038",
            "obj": "PMID:1342834",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:17504714",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:1342834",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:9627156",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "mandibuloacral dysplasia with type A lipodystrophy",
        "id": "MONDO:0009557"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "4f5e3846-9a20-4127-a5f4-03ff42668368",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONARCH:18355d352a955a56",
            "lbl": null
          },
          {
            "id": "MONDO:0009557",
            "lbl": "mandibuloacral dysplasia with type A lipodystrophy"
          },
          {
            "id": "HP:0040282",
            "lbl": "Frequent"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:18355d352a955a56",
            "obj": "MONDO:0009557",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:18355d352a955a56",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONDO:0009557",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:18355d352a955a56",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "hyperprolactinemia (disease)",
        "id": "MONDO:0005804"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "bd92eb50-b30e-4e40-a875-3755e782660c",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:12841542",
            "lbl": null
          },
          {
            "id": "MONARCH:109a86b3db2449e3",
            "lbl": null
          },
          {
            "id": "PMID:1885092",
            "lbl": null
          },
          {
            "id": "PMID:9203996",
            "lbl": null
          },
          {
            "id": "MONDO:0005804",
            "lbl": "hyperprolactinemia (disease)"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:3061857",
            "lbl": null
          },
          {
            "id": "PMID:17558684",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:109a86b3db2449e3",
            "obj": "PMID:12841542",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0005804",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:109a86b3db2449e3",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:109a86b3db2449e3",
            "obj": "MONDO:0005804",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:109a86b3db2449e3",
            "obj": "PMID:3061857",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:109a86b3db2449e3",
            "obj": "PMID:1885092",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:109a86b3db2449e3",
            "obj": "PMID:17558684",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:109a86b3db2449e3",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:109a86b3db2449e3",
            "obj": "PMID:9203996",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:17558684",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:3061857",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:9203996",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:1885092",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:12841542",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "diabetic angiopathy",
        "id": "MONDO:0006725"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "b024e293-40eb-4045-88f4-72337c0424be",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0006725",
            "lbl": "diabetic angiopathy"
          },
          {
            "id": "PMID:21143169",
            "lbl": null
          },
          {
            "id": "PMID:16847701",
            "lbl": null
          },
          {
            "id": "MONARCH:1b88ff0ba9916f69",
            "lbl": null
          },
          {
            "id": "PMID:7851274",
            "lbl": null
          },
          {
            "id": "PMID:19997571",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:10843169",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:1b88ff0ba9916f69",
            "obj": "PMID:10843169",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1b88ff0ba9916f69",
            "obj": "PMID:16847701",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1b88ff0ba9916f69",
            "obj": "PMID:7851274",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0006725",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:1b88ff0ba9916f69",
            "obj": "PMID:21143169",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1b88ff0ba9916f69",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:1b88ff0ba9916f69",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:1b88ff0ba9916f69",
            "obj": "MONDO:0006725",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:1b88ff0ba9916f69",
            "obj": "PMID:19997571",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:7851274",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19997571",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21143169",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:10843169",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:16847701",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Turner syndrome",
        "id": "MONDO:0019499"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "2de289b4-339b-41eb-999c-95999e7a8585",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:15529627",
            "lbl": null
          },
          {
            "id": "PMID:9439548",
            "lbl": null
          },
          {
            "id": "MONDO:0019499",
            "lbl": "Turner syndrome"
          },
          {
            "id": "PMID:21378088",
            "lbl": null
          },
          {
            "id": "MONARCH:17f48a5c3d827fbf",
            "lbl": null
          },
          {
            "id": "PMID:7637644",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:11220703",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:17f48a5c3d827fbf",
            "obj": "PMID:9439548",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:17f48a5c3d827fbf",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:17f48a5c3d827fbf",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:17f48a5c3d827fbf",
            "obj": "PMID:7637644",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0019499",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:17f48a5c3d827fbf",
            "obj": "PMID:21378088",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:17f48a5c3d827fbf",
            "obj": "MONDO:0019499",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:17f48a5c3d827fbf",
            "obj": "PMID:15529627",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:17f48a5c3d827fbf",
            "obj": "PMID:11220703",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:21378088",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:11220703",
          "deprecated": null,
"""
  def part12: String =
"""
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:7637644",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:9439548",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15529627",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "monosomy 13q34",
        "id": "MONDO:0019902"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "bf7c022c-ff8a-4bf3-b136-a148305b3e70",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "MONDO:0019902",
            "lbl": "monosomy 13q34"
          },
          {
            "id": "MONARCH:e3303453181563bf",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "HP:0040283",
            "lbl": "Occasional"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:e3303453181563bf",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:e3303453181563bf",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONDO:0019902",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:e3303453181563bf",
            "obj": "MONDO:0019902",
            "pred": "OBAN:association_has_subject"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Woodhouse-Sakati syndrome",
        "id": "MONDO:0009419"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "9ddfeace-10eb-43fb-b903-cf5cce6834b6",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "MONARCH:7e9400cced706fe4",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "HP:0040281",
            "lbl": "Very frequent"
          },
          {
            "id": "MONDO:0009419",
            "lbl": "Woodhouse-Sakati syndrome"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:7e9400cced706fe4",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONDO:0009419",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:7e9400cced706fe4",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:7e9400cced706fe4",
            "obj": "MONDO:0009419",
            "pred": "OBAN:association_has_subject"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "mandibuloacral dysplasia with type B lipodystrophy",
        "id": "MONDO:0012074"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "4ab42ec5-64c9-4e27-8c8c-06b1362449f4",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONARCH:9b1e49b3cf4b7e7a",
            "lbl": null
          },
          {
            "id": "MONDO:0012074",
            "lbl": "mandibuloacral dysplasia with type B lipodystrophy"
          },
          {
            "id": "HP:0040282",
            "lbl": "Frequent"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0012074",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:9b1e49b3cf4b7e7a",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:9b1e49b3cf4b7e7a",
            "obj": "MONDO:0012074",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:9b1e49b3cf4b7e7a",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "familial combined hyperlipidemia",
        "id": "MONDO:0001807"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "d0a56e6c-73be-40ec-b0f0-a22b7bb3251a",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:11574425",
            "lbl": null
          },
          {
            "id": "PMID:9261281",
            "lbl": null
          },
          {
            "id": "MONARCH:1bff845b1e65c063",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:9399729",
            "lbl": null
          },
          {
            "id": "PMID:16677651",
            "lbl": null
          },
          {
            "id": "PMID:21947005",
            "lbl": null
          },
          {
            "id": "MONDO:0001807",
            "lbl": "familial combined hyperlipidemia"
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:1bff845b1e65c063",
            "obj": "PMID:11574425",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1bff845b1e65c063",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONDO:0001807",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:1bff845b1e65c063",
            "obj": "PMID:9399729",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1bff845b1e65c063",
            "obj": "PMID:9261281",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1bff845b1e65c063",
            "obj": "PMID:16677651",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:1bff845b1e65c063",
            "obj": "MONDO:0001807",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:1bff845b1e65c063",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:1bff845b1e65c063",
            "obj": "PMID:21947005",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:9261281",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:11574425",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:16677651",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:9399729",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21947005",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "diabetic ketoacidosis",
        "id": "MONDO:0012819"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "dbb4acff-0b21-41d2-a8f4-a2a37768611b",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "PMID:109340",
            "lbl": null
          },
          {
            "id": "MONDO:0012819",
            "lbl": "diabetic ketoacidosis"
          },
          {
            "id": "PMID:17277319",
            "lbl": null
          },
          {
            "id": "MONARCH:72d2918e1ce30bee",
            "lbl": null
          },
          {
            "id": "MONARCH:5741bc91f7e66a9f",
            "lbl": null
          },
          {
            "id": "PMID:1519609",
            "lbl": null
          },
          {
            "id": "PMID:18547233",
            "lbl": null
          },
          {
            "id": "PMID:19087951",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0012819",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONDO:0012819",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:5741bc91f7e66a9f",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:5741bc91f7e66a9f",
            "obj": "PMID:18547233",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:5741bc91f7e66a9f",
            "obj": "PMID:17277319",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:5741bc91f7e66a9f",
            "obj": "PMID:1519609",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:5741bc91f7e66a9f",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:72d2918e1ce30bee",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:5741bc91f7e66a9f",
            "obj": "PMID:109340",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:72d2918e1ce30bee",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:5741bc91f7e66a9f",
            "obj": "MONDO:0012819",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:5741bc91f7e66a9f",
            "obj": "PMID:19087951",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:72d2918e1ce30bee",
            "obj": "MONDO:0012819",
            "pred": "OBAN:association_has_subject"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:18547233",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:1519609",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17277319",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:109340",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19087951",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "acromegaly",
        "id": "MONDO:0019933"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "a21bc657-873a-49f0-8935-9602aa77464b",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:16141180",
            "lbl": null
          },
          {
            "id": "PMID:20417901",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "PMID:11716617",
            "lbl": null
          },
          {
            "id": "MONDO:0019933",
            "lbl": "acromegaly"
          },
          {
            "id": "PMID:22703122",
            "lbl": null
          },
          {
            "id": "MONARCH:ffe95b0f30f7f7d0",
            "lbl": null
          },
          {
            "id": "PMID:17322492",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:ffe95b0f30f7f7d0",
            "obj": "PMID:22703122",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ffe95b0f30f7f7d0",
            "obj": "PMID:16141180",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ffe95b0f30f7f7d0",
            "obj": "PMID:20417901",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0019933",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:ffe95b0f30f7f7d0",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:ffe95b0f30f7f7d0",
            "obj": "PMID:17322492",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ffe95b0f30f7f7d0",
            "obj": "PMID:11716617",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ffe95b0f30f7f7d0",
            "obj": "MONDO:0019933",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:ffe95b0f30f7f7d0",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:16141180",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17322492",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20417901",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22703122",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:11716617",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "partial acquired lipodystrophy",
        "id": "MONDO:0012104"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "6c1b62db-a87b-4b93-9cfe-576a62b7d9d3",
      "evidence_graph": {
        "nodes": [
          {
            "id": "ECO:0000304",
            "lbl": "traceable author statement used in manual assertion"
          },
          {
            "id": "MONARCH:427bce5ea28e879c",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONDO:0012104",
            "lbl": "partial acquired lipodystrophy"
          },
          {
            "id": "HP:0040283",
            "lbl": "Occasional"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0012104",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:427bce5ea28e879c",
            "obj": "ECO:0000304",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:427bce5ea28e879c",
            "obj": "MONDO:0012104",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:427bce5ea28e879c",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": null,
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "papillary craniopharyngioma",
        "id": "MONDO:0002788"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "78120462-e3f6-41e0-abb7-e901a57e5fc4",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:10373342",
            "lbl": null
          },
          {
            "id": "PMID:20332250",
            "lbl": null
          },
          {
            "id": "MONDO:0002788",
            "lbl": "papillary craniopharyngioma"
          },
          {
            "id": "MONARCH:a42b544b7b165d03",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:15687345",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          },
          {
            "id": "PMID:8879991",
            "lbl": null
          },
          {
            "id": "PMID:19766264",
            "lbl": null
"""
  def part13: String =
"""
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:a42b544b7b165d03",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONDO:0002788",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:a42b544b7b165d03",
            "obj": "PMID:8879991",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a42b544b7b165d03",
            "obj": "PMID:20332250",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a42b544b7b165d03",
            "obj": "PMID:10373342",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a42b544b7b165d03",
            "obj": "MONDO:0002788",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:a42b544b7b165d03",
            "obj": "PMID:15687345",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a42b544b7b165d03",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:a42b544b7b165d03",
            "obj": "PMID:19766264",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:8879991",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20332250",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:10373342",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15687345",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19766264",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "chronic hepatitis B",
        "id": "MONDO:0005366"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "b38a2dd4-ccbd-4517-ad58-87ceca581270",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:15784031",
            "lbl": null
          },
          {
            "id": "MONARCH:bcbc694a533475c5",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:17650292",
            "lbl": null
          },
          {
            "id": "PMID:21934202",
            "lbl": null
          },
          {
            "id": "MONDO:0005366",
            "lbl": "chronic hepatitis B"
          },
          {
            "id": "PMID:12967337",
            "lbl": null
          },
          {
            "id": "PMID:21428191",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:bcbc694a533475c5",
            "obj": "PMID:12967337",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:bcbc694a533475c5",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:bcbc694a533475c5",
            "obj": "PMID:17650292",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0005366",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:bcbc694a533475c5",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:bcbc694a533475c5",
            "obj": "PMID:21934202",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:bcbc694a533475c5",
            "obj": "PMID:21428191",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:bcbc694a533475c5",
            "obj": "PMID:15784031",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:bcbc694a533475c5",
            "obj": "MONDO:0005366",
            "pred": "OBAN:association_has_subject"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:17650292",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:12967337",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15784031",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21934202",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21428191",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "peripheral arterial disease",
        "id": "MONDO:0005386"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "e6ef4ff8-04d9-46d7-b56d-a4dcfd5d130b",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:20121883",
            "lbl": null
          },
          {
            "id": "MONARCH:ab35bd84cffbc268",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONDO:0005386",
            "lbl": "peripheral arterial disease"
          },
          {
            "id": "PMID:22108456",
            "lbl": null
          },
          {
            "id": "PMID:22153698",
            "lbl": null
          },
          {
            "id": "PMID:22402937",
            "lbl": null
          },
          {
            "id": "PMID:20554280",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:ab35bd84cffbc268",
            "obj": "PMID:22153698",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0005386",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:ab35bd84cffbc268",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:ab35bd84cffbc268",
            "obj": "PMID:22402937",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ab35bd84cffbc268",
            "obj": "PMID:22108456",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ab35bd84cffbc268",
            "obj": "MONDO:0005386",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:ab35bd84cffbc268",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:ab35bd84cffbc268",
            "obj": "PMID:20121883",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:ab35bd84cffbc268",
            "obj": "PMID:20554280",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:20554280",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22153698",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20121883",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22108456",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22402937",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "diabetes mellitus (disease)",
        "id": "MONDO:0005015"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "e9bc8cba-60fe-4512-bf6a-a0f63e9b52ac",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:10615957",
            "lbl": null
          },
          {
            "id": "MONDO:0005015",
            "lbl": "diabetes mellitus (disease)"
          },
          {
            "id": "PMID:17349054",
            "lbl": null
          },
          {
            "id": "HP:0008255",
            "lbl": "Transient neonatal diabetes mellitus"
          },
          {
            "id": "PMID:19155788",
            "lbl": null
          },
          {
            "id": "PMID:11334617",
            "lbl": null
          },
          {
            "id": "PMID:10204843",
            "lbl": null
          },
          {
            "id": "MONARCH:e3adb383aed6b031",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:e3adb383aed6b031",
            "obj": "PMID:19155788",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:e3adb383aed6b031",
            "obj": "PMID:11334617",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0005015",
            "obj": "HP:0008255",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:e3adb383aed6b031",
            "obj": "HP:0008255",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:e3adb383aed6b031",
            "obj": "PMID:10615957",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:e3adb383aed6b031",
            "obj": "MONDO:0005015",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:e3adb383aed6b031",
            "obj": "PMID:17349054",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:e3adb383aed6b031",
            "obj": "PMID:10204843",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:e3adb383aed6b031",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:10615957",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17349054",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19155788",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:10204843",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:11334617",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Transient neonatal diabetes mellitus",
        "id": "HP:0008255"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "diabetic polyneuropathy",
        "id": "MONDO:0001583"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "0b064b47-b909-472f-ab52-dba819df22fa",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:11315843",
            "lbl": null
          },
          {
            "id": "PMID:20836762",
            "lbl": null
          },
          {
            "id": "PMID:12585102",
            "lbl": null
          },
          {
            "id": "HP:0000831",
            "lbl": "Insulin-resistant diabetes mellitus"
          },
          {
            "id": "MONARCH:3c0c0f73918ee2e0",
            "lbl": null
          },
          {
            "id": "PMID:8933190",
            "lbl": null
          },
          {
            "id": "PMID:19601918",
            "lbl": null
          },
          {
            "id": "MONDO:0001583",
            "lbl": "diabetic polyneuropathy"
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:3c0c0f73918ee2e0",
            "obj": "PMID:20836762",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0001583",
            "obj": "HP:0000831",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:3c0c0f73918ee2e0",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:3c0c0f73918ee2e0",
            "obj": "PMID:8933190",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:3c0c0f73918ee2e0",
            "obj": "PMID:19601918",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:3c0c0f73918ee2e0",
            "obj": "HP:0000831",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:3c0c0f73918ee2e0",
            "obj": "MONDO:0001583",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:3c0c0f73918ee2e0",
            "obj": "PMID:12585102",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:3c0c0f73918ee2e0",
            "obj": "PMID:11315843",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:20836762",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:11315843",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19601918",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:8933190",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:12585102",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin-resistant diabetes mellitus",
        "id": "HP:0000831"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "hyperthyroidism",
        "id": "MONDO:0004425"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "48a0731c-b77b-49ad-ac8d-34b38b4f0d01",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONARCH:f8aa885af4c6c566",
            "lbl": null
          },
          {
            "id": "PMID:3510924",
            "lbl": null
          },
          {
            "id": "PMID:8807641",
            "lbl": null
          },
          {
            "id": "PMID:6997327",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:7014195",
            "lbl": null
          },
          {
            "id": "MONDO:0004425",
            "lbl": "hyperthyroidism"
          },
          {
            "id": "PMID:3176815",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONDO:0004425",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:f8aa885af4c6c566",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:f8aa885af4c6c566",
            "obj": "PMID:3510924",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:f8aa885af4c6c566",
            "obj": "PMID:8807641",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:f8aa885af4c6c566",
            "obj": "MONDO:0004425",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:f8aa885af4c6c566",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:f8aa885af4c6c566",
            "obj": "PMID:7014195",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:f8aa885af4c6c566",
            "obj": "PMID:6997327",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:f8aa885af4c6c566",
            "obj": "PMID:3176815",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:3510924",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:8807641",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:3176815",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:7014195",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:6997327",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
"""
  def part14: String =
"""
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "gallstones",
        "id": "MONDO:0005346"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "975c54cd-3ea4-41f2-b985-3a540134d87b",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONARCH:b93c7c36252f384b",
            "lbl": null
          },
          {
            "id": "MONDO:0005346",
            "lbl": "gallstones"
          },
          {
            "id": "PMID:19017613",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:22074432",
            "lbl": null
          },
          {
            "id": "PMID:17045610",
            "lbl": null
          },
          {
            "id": "PMID:21916209",
            "lbl": null
          },
          {
            "id": "PMID:20880342",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:b93c7c36252f384b",
            "obj": "PMID:17045610",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:b93c7c36252f384b",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:b93c7c36252f384b",
            "obj": "MONDO:0005346",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:b93c7c36252f384b",
            "obj": "PMID:22074432",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:b93c7c36252f384b",
            "obj": "PMID:19017613",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:b93c7c36252f384b",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:b93c7c36252f384b",
            "obj": "PMID:21916209",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:b93c7c36252f384b",
            "obj": "PMID:20880342",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0005346",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:19017613",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17045610",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:21916209",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20880342",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22074432",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "uremia",
        "id": "MONDO:0007008"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "db6716b9-6adf-436d-9f31-946e5d5b9fb7",
      "evidence_graph": {
        "nodes": [
          {
            "id": "MONDO:0007008",
            "lbl": "uremia"
          },
          {
            "id": "PMID:19023195",
            "lbl": null
          },
          {
            "id": "MONARCH:09e03e89af572fbd",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:6349382",
            "lbl": null
          },
          {
            "id": "PMID:16112037",
            "lbl": null
          },
          {
            "id": "PMID:9083290",
            "lbl": null
          },
          {
            "id": "PMID:1858877",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:09e03e89af572fbd",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONDO:0007008",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:09e03e89af572fbd",
            "obj": "PMID:19023195",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:09e03e89af572fbd",
            "obj": "PMID:16112037",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:09e03e89af572fbd",
            "obj": "PMID:1858877",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:09e03e89af572fbd",
            "obj": "PMID:6349382",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:09e03e89af572fbd",
            "obj": "PMID:9083290",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:09e03e89af572fbd",
            "obj": "MONDO:0007008",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:09e03e89af572fbd",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:16112037",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:6349382",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:1858877",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:9083290",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19023195",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "systemic lupus erythematosus (disease)",
        "id": "MONDO:0007915"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "8ca3c8c3-2f35-4907-b364-9498868e4cb1",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:15459813",
            "lbl": null
          },
          {
            "id": "PMID:20693192",
            "lbl": null
          },
          {
            "id": "PMID:19620300",
            "lbl": null
          },
          {
            "id": "PMID:4043557",
            "lbl": null
          },
          {
            "id": "MONARCH:a0cdcfbbbdab3dd4",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "MONDO:0007915",
            "lbl": "systemic lupus erythematosus (disease)"
          },
          {
            "id": "PMID:21418882",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:a0cdcfbbbdab3dd4",
            "obj": "PMID:21418882",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a0cdcfbbbdab3dd4",
            "obj": "MONDO:0007915",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:a0cdcfbbbdab3dd4",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:a0cdcfbbbdab3dd4",
            "obj": "PMID:15459813",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a0cdcfbbbdab3dd4",
            "obj": "PMID:19620300",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0007915",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:a0cdcfbbbdab3dd4",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:a0cdcfbbbdab3dd4",
            "obj": "PMID:4043557",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a0cdcfbbbdab3dd4",
            "obj": "PMID:20693192",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:21418882",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:15459813",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:4043557",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:20693192",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19620300",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    },
    {
      "object": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "nephrolithiasis",
        "id": "MONDO:0008171"
      },
      "relation": {
        "label": "has phenotype",
        "id": "RO:0002200",
        "inverse": true
      },
      "type": null,
      "slim": null,
      "provided_by": [
        "https://data.monarchinitiative.org/ttl/hpoa.ttl"
      ],
      "object_extensions": null,
      "subject_extensions": null,
      "id": "1b9db990-e7da-4e2a-a276-04ebbe22edc4",
      "evidence_graph": {
        "nodes": [
          {
            "id": "PMID:17678984",
            "lbl": null
          },
          {
            "id": "MONDO:0008171",
            "lbl": "nephrolithiasis"
          },
          {
            "id": "PMID:22099686",
            "lbl": null
          },
          {
            "id": "MONARCH:a53271c62a9bc1a4",
            "lbl": null
          },
          {
            "id": "HP:0000855",
            "lbl": "Insulin resistance"
          },
          {
            "id": "PMID:17119545",
            "lbl": null
          },
          {
            "id": "PMID:19417722",
            "lbl": null
          },
          {
            "id": "PMID:19078968",
            "lbl": null
          },
          {
            "id": "ECO:0000246",
            "lbl": "computational combinatorial evidence used in automatic assertion"
          }
        ],
        "edges": [
          {
            "sub": "MONARCH:a53271c62a9bc1a4",
            "obj": "PMID:19078968",
            "pred": "dc:source"
          },
          {
            "sub": "MONDO:0008171",
            "obj": "HP:0000855",
            "pred": "RO:0002200"
          },
          {
            "sub": "MONARCH:a53271c62a9bc1a4",
            "obj": "PMID:19417722",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a53271c62a9bc1a4",
            "obj": "PMID:17119545",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a53271c62a9bc1a4",
            "obj": "PMID:22099686",
            "pred": "dc:source"
          },
          {
            "sub": "MONARCH:a53271c62a9bc1a4",
            "obj": "MONDO:0008171",
            "pred": "OBAN:association_has_subject"
          },
          {
            "sub": "MONARCH:a53271c62a9bc1a4",
            "obj": "HP:0000855",
            "pred": "OBAN:association_has_object"
          },
          {
            "sub": "MONARCH:a53271c62a9bc1a4",
            "obj": "ECO:0000246",
            "pred": "RO:0002558"
          },
          {
            "sub": "MONARCH:a53271c62a9bc1a4",
            "obj": "PMID:17678984",
            "pred": "dc:source"
          }
        ]
      },
      "negated": false,
      "qualifiers": null,
      "publications": [
        {
          "id": "PMID:17119545",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:17678984",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19078968",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:22099686",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        },
        {
          "id": "PMID:19417722",
          "deprecated": null,
          "replaced_by": null,
          "categories": null,
          "label": null,
          "types": null,
          "consider": null,
          "synonyms": null,
          "description": null
        }
      ],
      "evidence_types": null,
      "subject": {
        "taxon": {
          "label": null,
          "id": null
        },
        "label": "Insulin resistance",
        "id": "HP:0000855"
      }
    }
  ],
  "objects": [
    "MONDO:0001076",
    "MONDO:0001105",
    "MONDO:0001324",
    "MONDO:0001583",
    "MONDO:0001807",
    "MONDO:0002046",
    "MONDO:0002123",
    "MONDO:0002146",
    "MONDO:0002177",
    "MONDO:0002277",
    "MONDO:0002450",
    "MONDO:0002691",
    "MONDO:0002788",
    "MONDO:0002814",
    "MONDO:0002985",
    "MONDO:0003009",
    "MONDO:0004425",
    "MONDO:0004575",
    "MONDO:0004790",
    "MONDO:0004975",
    "MONDO:0005009",
    "MONDO:0005015",
    "MONDO:0005044",
    "MONDO:0005048",
    "MONDO:0005068",
    "MONDO:0005081",
    "MONDO:0005109",
    "MONDO:0005139",
    "MONDO:0005147",
    "MONDO:0005148",
    "MONDO:0005152",
    "MONDO:0005155",
    "MONDO:0005231",
    "MONDO:0005266",
    "MONDO:0005296",
    "MONDO:0005298",
    "MONDO:0005300",
    "MONDO:0005311",
    "MONDO:0005346",
    "MONDO:0005354",
    "MONDO:0005355",
    "MONDO:0005359",
    "MONDO:0005362",
    "MONDO:0005366",
    "MONDO:0005386",
    "MONDO:0005388",
    "MONDO:0005393",
    "MONDO:0005406",
    "MONDO:0005420",
    "MONDO:0005559",
    "MONDO:0005575",
    "MONDO:0005606",
    "MONDO:0005804",
    "MONDO:0005815",
    "MONDO:0005827",
    "MONDO:0005911",
    "MONDO:0005919",
    "MONDO:0006373",
    "MONDO:0006507",
    "MONDO:0006516",
    "MONDO:0006573",
    "MONDO:0006583",
    "MONDO:0006591",
    "MONDO:0006640",
    "MONDO:0006644",
    "MONDO:0006658",
    "MONDO:0006725",
    "MONDO:0006805",
    "MONDO:0006823",
    "MONDO:0006848",
    "MONDO:0006910",
    "MONDO:0006920",
    "MONDO:0007008",
    "MONDO:0007070",
    "MONDO:0007147",
    "MONDO:0007254",
    "MONDO:0007256",
    "MONDO:0007455",
    "MONDO:0007534",
    "MONDO:0007906",
    "MONDO:0007908",
    "MONDO:0007909",
    "MONDO:0007915",
    "MONDO:0008056",
    "MONDO:0008159",
    "MONDO:0008171",
    "MONDO:0008300",
    "MONDO:0008310",
    "MONDO:0008311",
    "MONDO:0008383",
    "MONDO:0008394",
    "MONDO:0008487",
    "MONDO:0008696",
    "MONDO:0008727",
    "MONDO:0008728",
    "MONDO:0008763",
    "MONDO:0008874",
    "MONDO:0009061",
    "MONDO:0009192",
    "MONDO:0009312",
    "MONDO:0009419",
    "MONDO:0009517",
    "MONDO:0009557",
    "MONDO:0009831",
    "MONDO:0009832",
    "MONDO:0009874",
    "MONDO:0009877",
    "MONDO:0009983",
    "MONDO:0010020",
    "MONDO:0010026",
    "MONDO:0010196",
    "MONDO:0010802",
    "MONDO:0010813",
    "MONDO:0011073",
    "MONDO:0011448",
    "MONDO:0011565",
    "MONDO:0011643",
    "MONDO:0011714",
    "MONDO:0011849",
    "MONDO:0012071",
    "MONDO:0012072",
    "MONDO:0012074",
    "MONDO:0012104",
    "MONDO:0012110",
    "MONDO:0012192",
    "MONDO:0012268",
    "MONDO:0012381",
    "MONDO:0012480",
    "MONDO:0012522",
    "MONDO:0012819",
    "MONDO:0012923",
    "MONDO:0013225",
    "MONDO:0013301",
    "MONDO:0013478",
    "MONDO:0013842",
    "MONDO:0013991",
    "MONDO:0013992",
    "MONDO:0014098",
    "MONDO:0014157",
    "MONDO:0014309",
    "MONDO:0014402",
    "MONDO:0014420",
    "MONDO:0014431",
    "MONDO:0014686",
    "MONDO:0015493",
    "MONDO:0015892",
    "MONDO:0016464",
    "MONDO:0016584",
    "MONDO:0017045",
    "MONDO:0017230",
    "MONDO:0017406",
    "MONDO:0018034",
    "MONDO:0018099",
    "MONDO:0018465",
    "MONDO:0018575",
    "MONDO:0018882",
    "MONDO:0018883",
    "MONDO:0018912",
    "MONDO:0019192",
    "MONDO:0019193",
    "MONDO:0019321",
    "MONDO:0019402",
    "MONDO:0019499",
    "MONDO:0019599",
    "MONDO:0019902",
    "MONDO:0019921",
    "MONDO:0019933",
    "MONDO:0020088",
    "MONDO:0020525",
    "MONDO:0021063"
  ],
  "docs": null,
  "numFound": 209
}
"""
}
