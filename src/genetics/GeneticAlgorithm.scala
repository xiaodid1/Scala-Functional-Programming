package genetics

import music._
import statistics._

object GeneticAlgorithm {

      def geneticAlgorithm2[T](incubator: List[Double] => T, costFunction: T => Double, nGenes: Int, animalList: List[List[Double]], count: Int): T = {
          if(count <= 1000){
            val animalSorted = animalList.sortBy((genes: List[Double]) => costFunction(incubator(genes)))
            val bestOneAnimal = animalSorted.head

            val muted = animalSorted.take(20).map((genes: List[Double]) => {
                  genes.map((gene: Double) => {
                            val rand = math.random() * 0.01
                            if (Math.random() < 0.5) {
                                gene + rand
                            } else {
                                gene - rand
                            }
                        })
              })

            val bestMutsList = bestOneAnimal::muted
            val bestMutSort = bestMutsList.sortBy((genes: List[Double]) => costFunction(incubator(genes)))
            val parent = bestMutSort.head
            val parent1 = bestMutSort.apply(1)

            val offspring: List[Double] = (for (i <- parent.indices) yield{
              if (math.random() < 0.5){
                parent1.apply(i)
              }else{
                parent.apply(i)
              }
            }).toList

            val offSpringMuts = offspring :: bestMutSort

            val rAnimals: List[List[Double]] = (for (i <- 1 to 100) yield{
              (for (i <- 1 to nGenes) yield{
                val rand = math.random() * 1000
                if (Math.random() < 0.5){
                  -rand
                }else{
                  rand
                }
              }).toList
            }).toList
            val result = offSpringMuts ++ rAnimals

            geneticAlgorithm2(incubator, costFunction, nGenes, result, count+1)
          }else{
            val lastlist = animalList.sortBy((genes: List[Double]) => costFunction(incubator(genes)))
            val best = lastlist.head
            incubator(best)
          }
    }


    def geneticAlgorithm[T](incubator: List[Double] => T, costFunction: T => Double, nGenes: Int): T ={

      val rAnimals: List[List[Double]] = (for(i <- 1 to 1000) yield{
        (for (i <- 1 to nGenes) yield{
          val rand = math.random() * 1000
          if (math.random() < 0.5){
            -rand
          }else{
            rand
          }
        }).toList
      }).toList
      geneticAlgorithm2(incubator,costFunction,nGenes,rAnimals,0)
    }
}
