(ns joy.core)

(defn traverse [node f]
  (when node
    (f node)
    (doseq [child (:content node)]
      (traverse child f))))


(traverse {:tag :flower :attrs {:name "Tanpopo"} :content []}
          println)
;; {:tag :flower, :attrs {:name Tanpopo}, :content []}


(use  '[clojure.xml :as xml])

(def DB
  (-> "<zoo>
         <pongo>
           <animal>orangutan</animal>
         </pongo>
         <panthera>
           <animal>Spot</animal>
           <animal>lion</animal>
           <animal>Lopshire</animal>
         </panthera>
       </zoo>"
     .getBytes
     (java.io.ByteArrayInputStream.)
     xml/parse))


(defn ^:dynamic handle-weird-animal
  [{[name] :content}]
  (throw (Exception. (str name " must be 'dealt with'"))))


(defmulti visit :tag)

(defmethod visit :animal [{[name] :content :as animal}]
  (case name
    "Spot"     (handle-weird-animal animal)
    "Lopshire" (handle-weird-animal animal)
    (println name)))

(defmethod visit :default [node] nil)


(traverse DB visit)
; orangutan
; Exception Spot must be 'dealt with'


(defmulti handle-weird  (fn [{[name] :content}] name))

(defmethod handle-weird "Spot" [_]
  (println "Transporting Spot to the circus."))

(defmethod handle-weird "Lopshire" [_]
  (println "Signing Lopshire to a book deal."))

(binding [handle-weird-animal handle-weird]
  (traverse DB visit))

; orangutan
; Transporting Spot to the circus.
; lion
; Signing Lopshire to a book deal.


(def _ (future
         (binding [handle-weird-animal #(println (:content %))]
           (traverse DB visit))))

; orangutan
; [Spot]
; lion
; [Lopshire]
