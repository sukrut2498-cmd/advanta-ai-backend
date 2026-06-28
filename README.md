# AdVanta AI — Core Governance Backend Engine
### Technical Specification & Microservice Operational Manual

---

## 🏛️ System Architecture Design Specification
The AdVanta AI Backend is built as an enterprise-grade, deterministic Spring Boot microservice running on **Java 17**. It handles incoming multi-part processing pipelines, content synthesis normalization, and programmatic brand safety routing.


### Data Flow Lifecycle:
1. **Ingestion Boundary:** The API exposes a high-throughput multipart destination (`/api/v1/campaigns/generate`) that accepts metadata string keys alongside raw document streams.
2. **Text Preprocessing:** White spaces, line breaks, and raw inputs are stripped using regex-based structural text normalization routines.
3. **Localization Routing:** Analyzes incoming text context payload modifiers to dynamically intercept and swap internal string templates for English, Hindi, and Marathi locales.
4. **Safety Analysis:** Evaluates the finalized content strings against the compliance matrix before packaging a structured JSON map response.

---

## 🔍 Validation & Compliance Workflow Breakdown

### The 85% Brand Compliance Matrix Calculation
The engine applies programmatic evaluation rules against the generated draft to guarantee brand equity. Starting from a base score of **100%**, strict deductions are applied:
* **High-Pressure Urgency Trap (-15%):** Scans for aggressive conversion signals like *"Buy now"*, *"Act now"*, *"आत्ताच खरेदी करा"*, or *"अभी खरीदें"*.
* **Cross-Channel Syntax Leak (-10%):** Flags cross-channel syntax faults, such as social media constructs (hashtags `#`) leaking into email body templates.
* **Context Disconnection (-10%):** Validates if core structural phrases extracted from file ingestion briefs are fully reflected in the final output generation layer.
* **Generic Signatory Notice (-5%):** Catches anonymous fallbacks like *"Marketing Team"* or *"मार्केटिंग टीम"* to mandate personalized signatures.

---

## 🚀 Local Execution Quick-Start Guide

### 🟢 Prerequisites
* **Java 17+ Installed** (JDK 17 mapped to `JAVA_HOME`).
* **Maven 3.8+** or the included Maven wrapper (`mvnw`).
