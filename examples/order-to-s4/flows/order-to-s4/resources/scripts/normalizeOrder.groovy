// normalizeOrder.groovy
// Spec ref: §26.3 reference scenario.
//
// Executed via the OIW JVM Groovy bridge (services/runtime-worker-jvm).
// The bridge provides: body (String), headers (Map), properties (Map), contentType (String).
//
// This script parses the JSON body and extracts the region field,
// then sets it as a property so the content-based router can branch on it.

import groovy.json.JsonSlurper

def json = new JsonSlurper().parseText(body)
def region = json.region ?: "GLOBAL"

// Set the region property so the router can branch on it
properties["region"] = region

// Add a normalization header
headers["X-Normalized-By"] = "oiw-groovy-bridge"
